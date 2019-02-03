package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

/**
 * Servlet implementation class NewsPicture
 */
@WebServlet("/NewsPicture")
public class NewsPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsPicture() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("... in newspicture");
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir"); //每个servlet上下文都有一个临时储存目录
		factory.setRepository(repository);  //File类型是系统临时文件

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem item : items) {
				System.out.println("in loop");
				
				String filename=item.getName();
				String suffix=filename.substring(filename.lastIndexOf('.')); //取后缀
				UUID uuid=UUID.randomUUID(); //随机文件名
				String prefix=uuid.toString();
				String finalfilename=(prefix+suffix).replace("-","");
				System.out.println("finalfilename: " + finalfilename);
				
				String path=servletContext.getRealPath("/images");
				InputStream is=item.getInputStream();
				String realpath=path+File.separator+filename;
				System.out.println("realpath: "+realpath);
				
				OutputStream os=new FileOutputStream(new File(realpath));
				byte[] b=new byte[1024];
				int len;
				while((len=is.read(b))!=-1) {
					System.out.print(".");
					os.write(b, 0, len);
				}
				is.close();
				os.close();
				
				request.setAttribute("head", "images/"+finalfilename);
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			}
		}catch(FileUploadException e) {
			e.printStackTrace();
			return;
		}
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
