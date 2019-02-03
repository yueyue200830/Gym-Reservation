package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dbconns.NewsDAO;
import dbconns.NewsDAOImpl;

/**
 * Servlet implementation class NewsAdd
 */
@WebServlet("/NewsAdd")
public class NewsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewsAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("... in news-add");
		String newTitle="";
		String newContent="";
		String newPhoto="";
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir"); // 每个servlet上下文都有一个临时储存目录
		factory.setRepository(repository); // File类型是系统临时文件

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				// 如果是普通的form元素
				if (item.isFormField()) {
					String filename = item.getFieldName();
					String value = item.getString("utf-8");
					if (filename.equals("newTitle")) {
						newTitle=value;
					} else if (filename.equals("newContent")) {
						newContent=value;
					} 
				} else {
					String filename = item.getName();
					System.out.println("file uploaded: " + filename);
					String suffix = filename.substring(filename.lastIndexOf('.'));   // 获取文件名的后缀
					UUID uuid = UUID.randomUUID(); // 用来生成随机文件名
					String prefix = uuid.toString();  
					String savefilename = prefix + suffix; //拼接后的文件名
					savefilename = savefilename.replace("-", "");

					String path = servletContext.getRealPath("/images");  // 结果是项目绝对路径+images
					newPhoto=savefilename; //实体类中只存名字
					System.out.println("path: " + path);
					
					InputStream is = item.getInputStream();
					OutputStream os = new FileOutputStream(new File(path + File.separator + savefilename)); // File.separator为本地默认的目录分隔符
					byte[] b = new byte[1024];
					int len;
					while ((len = is.read(b)) != -1) { // 一个个字节存
						os.write(b, 0, len);
					}
					is.close();
					os.close();
				}
			}
			
			NewsDAO nd=new NewsDAOImpl();
			boolean flag=nd.add(newTitle, newContent, newPhoto);
			System.out.println("news add: " + flag);
			
			if(flag) {
				request.getRequestDispatcher("managernews.jsp").forward(request, response);
			}else{
				System.out.println("-- add news failed --");
				PrintWriter out = response.getWriter();
				out.flush();
				out.println("<script>");
				out.println("alert('新闻发布失败');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
