import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Student extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      String title = "Student Data";
      String docType ="<!doctype html>\n";
      String value=request.getParameter("RegValue");
      String resultname="";
      Integer resultrank=0;
      
        Student1[] arr;
   
        arr = new Student1[5];
        arr[0] = new Student1(1001, "Milo",2);
        arr[1] = new Student1(1002, "cleo",5);
        arr[2] = new Student1(1003, "berry",1);
        arr[3] = new Student1(1004, "lab",4);
        arr[4] = new Student1(1005, "chichu",3);
        for(int i=0;i<arr.length;i++){
            if(arr[i].id==Integer.parseInt(value)){
                  resultname=arr[i].name;
                  resultrank=arr[i].rank;
                  break;
         }
        }

      out.println(docType +
         "<html>\n" +
            "<head><title>" + title + "</title></head>\n"+"<style>table, td, th { border: 1px solid blue;} table {border-collapse: collapse;width: 100%;} td { text-align: center;}</style>\n" +
            "<body bgcolor = \"#f0f0f0\">\n" +
               "<center><h1 align = \"center\">" + title + "</h1>\n" +
               "<table>"+   
               "<thead><th>Student Reg No</th><th>Student Name</th><th>Student Rank</th></thead>\n"+
               "<tbody><tr><td>"+value+"</td><td>"+resultname+" </td><td>"+resultrank+" </td> </tr></tbody>"+
            "</table>"+"</body>"+            
        "</html>"
      );
   }
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {     
      doGet(request, response);
   }
   class Student1 { 
      public int id;
      public String name;
      public int rank;
   
      Student1(int id, String name,int rank)
      {
          this.id = id;
          this.name = name;
          this.rank=rank;
      }
   
}
}