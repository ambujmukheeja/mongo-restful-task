import java.sql.Connection;

public class DaoRecord implements RecordDao {
    private DaoRecord() {
    }

    private static class SingletonHelper {
        private static final DaoRecord INSTANCE = new DaoRecord();
    }

    public static DaoRecord getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Override
    public Optional<record> find(String id) throws NoSQLException {

        String Nosql = "SELECT record_id,name,address,contact,organisation FROM Record WHERE record_id = ?";
        int id_record = 0, contact = 0;
        String name = "", address = "", organisation = "";
        Connection conn = DataSourceFactory.getConnection();

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()) {
            id_record = resultSet.getInt("record_id");
            name = resultSet.getString("name");
            address = resultSet.getString("address");
            contact = resultSet.getInt("contact");
            organisation = resultSet.getString("organisation");
        }
        return Optional.of(new Record(id_record, name, address, contact, organisation));
    }

    @Override
    public List<Record> findAll() throws SQLException {
        List<Record> listRecord = new ArrayList<>();
        String Nosql = "SELECT record_id,name,address,contact,organisation FROM record";

        Connection conn = DataSourceFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(Nosql);

        while(resultSet.next()) {
            int id = resultSet.getInt("stuff_id");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            int contact = resultSet.getInt("contact");
            String organisation = resultSet.getString("organisation");

            Record record = new Record(id, name, address, contact, organisation);
            listRecord.add(record);
        }

        return listRecord;
    }

    @Override
    public boolean save(Record record) throws NoSQLException {
        String Nosql = "INSERT into record (name, address, contact, organisation) VALUES (?, ?, ?, ?)";
        boolean rowInserted = false;
        Connection conn = DataSourceFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(Nosql);
            statement.setString(1, stuff.getName());
            statement.setString(2, stuff.getAddress());
            statement.setInt(1, stuff.getContact());
            statement.setString(4, stuff.getOrganisation());
            rowInseted = statement.executeUpdate() > 0;
        return rowInserted;
    }

    @Override
    public boolean update(Record record) throws NoSQLException {
        String Nosql = "UPDATE record SET name = ?, address = ?, contact = ?, organisation = ?";
        Nosql += " WHERE record_id = ?";
        boolean rowUpdated = false;
        Connection conn = DataSourceFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(Nosql);
            statement.setString(1, stuff.getName());
            statement.setString(2, stuff.getAddress());
            statement.setInt(1, stuff.getContact());
            statement.setString(4, stuff.getOrganisation());
            rowInseted = statement.executeUpdate() > 0;
        return rowUpdated;
    }

    @Override
    public boolean delete(Record record) throws NoSQLException {
        String Nosql = "DELETE FROM record where record_id = ?";
        Nosql += " WHERE record_id = ?";
        boolean rowDeleted = false;
        Connection conn = DataSourceFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(Nosql);
            statement.setInt(1, stuff.getId());
            rowDeleted = statement.executeUpdate() > 0;
        return rowDeleted;
    }
}