import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;

public class RecordController extends HttpServlet{
    private static final long serialVersionID =1L;
    private DaoRecord recordDao = DaoRecord.getInstance();
    private static final Logger LOGGER = Logger.getLogger(StuffController.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getServletPath();
        try {
            switch(action) {
                case "/nem":
                    showNewForm(req, resp);
                    break;
                case "/insert":
                    insertRecord(req, resp);
                    break;
                case "/delete":
                    deleteRecord(req, resp);
                    break;
                case "/edit":
                    showEditForm(req, resp);
                    break;
                case "/update":
                    updateRecord(req, resp);
                    break;
                default:
                    listRecord(req, resp);
                    break;
            }
        } catch(NoSQLException e) {
            // For simplicity just Logging the Exceptions
            LOGGER.log(Level.SEVERE, "NoSQL Error", e);
        }
    }

private void updateRecord(HttpServletRequest req, HttpServletResponse resp)
throws NoSQLException, IOException, ServletException {
    int id = Integer.parseInt(req.getParameter("id"));
    String name = req.getParameter("name");
    String address = req.getParameter("address");
    int contact = Integer.parseInt(req.getParameter("contact"));
    String organisation = req.getParameter("organisation");
    
    Record record = new Record(id, name, address, contact, organisation);
    recordDao.update(record);
    resp.sendRedirect("list");
    }    
}

private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
throws NoSQLException, IOException, ServletException {
    String id = req.getParameter("id");
    Optional<Record> existingRecord = recordDao.find("id");
    RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/RecordForm.jsp");
    existingRecord.ifPresent(s->req.setAttribute("record", s));
    dispatcher.forward(req, resp);
}

private void deleteRecord(HttpServletRequest req, HttpServletResponse resp)
throws NoSQLException, IOException, ServletException {
    int id = Integer.parseInt(req.getParameter("id"));
    Record record = new Record(id);
    recordDao.delete(record);
    resp.sendRedirect("list");
}

private void insertRecord(HttpServletRequest req, HttpServletResponse resp)
throws NoSQLException, IOException, ServletException {
    String name = req.getParameter("name");
    Sting address = req.getParameter("address");
    int contact = Integer.parseInt(getParameter("contact"));
    String organisation = req.getParameter("organisation");
    Record newRecord = new Record(name, address, contact, organisation);
    recordDao.save(newRecord);
    resp.sendRedirect("list");
}

private void showNewForm(HttpServletRequest req, HttpServletResponse resp)
throws NoSQLException, IOException, ServletException {
    RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/RecordForm.jsp");
    dispatcher.forward(req, resp);
}

private void listRecord(HttpServletRequest req, HttpServletResponse resp)
throws NoSQLException, IOException, ServletException {
    RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/RecordList.jsp");
    List<Record> listRecord = recordDao.findAll();
    req.setAttribute("listRecord", listRecord);
    dispatcher.forward(req, resp);
}
