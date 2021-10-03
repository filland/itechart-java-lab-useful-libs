package com.itechart;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "uploadFileServlet",
        urlPatterns = "/upload-file"
)
public class FileUploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Before you can work with the uploaded items, of course, you need to parse the request itself.
        // Ensuring that the request is actually a file upload request is straightforward,
        // but FileUpload makes it simplicity itself, by providing a static method to do just that.
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            // logging the error...
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Set factory constraints
        // Max constraint - when max is run out, data is written in temp directory
        // set 1MB
        factory.setSizeThreshold(1024 * 1024);
        File tempDir = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");

        // sets temporary location to store files
        factory.setRepository(tempDir);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint. (file + form data).  Set to 10 MB
        upload.setSizeMax(1024 * 1024 * 10);
        upload.setFileSizeMax(1024 * 1024 * 3);  // max individual file size

        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (item.isFormField()) {
                    processFormField(item);
                } else {
                    processUploadedFile(item);
                }
            }

            sendUploadingResults(request, response, "Success! File was uploaded.");
        } catch (FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
            sendUploadingResults(request, response, "Error. File's size is too big!");
        } catch (Exception e) {
            e.printStackTrace();
            sendUploadingResults(request, response, "Error. File was not uploaded for an unknown reason");
        }
    }

    private void processUploadedFile(FileItem item) throws Exception {
        String fileName = item.getName();
//        String fieldName = item.getFieldName();
//        String contentType = item.getContentType();
//        boolean isInMemory = item.isInMemory();
//        long sizeInBytes = item.getSize();

        // Process a file upload
        File uploadedFile = new File("./files/" + fileName);
        item.write(uploadedFile);
    }

    private void processFormField(FileItem item) {
        String name = item.getFieldName();
        String value = item.getString();  // Log field name and content etc...
        System.out.println("Form field = " + name + " = " + value);
    }

    private void sendUploadingResults(HttpServletRequest request, HttpServletResponse response, String s) throws ServletException, IOException {
        request.setAttribute("message", s);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }
}



