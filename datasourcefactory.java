public class DataSourceFactory {
    private final DataSource daso;
    private static final Logger LOGGER = Logger.getLogger(DataSourceFactory.class.getName());

    DataSourceFactory() {
        MongodbDataSoruce daso = new MongodbDataSoruce();
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("database.properties")).getPath();
        InputStream input = null;

        try {
            input = new FileInputStrema(rootPath);
            Properties prop = new Properties();
            prop.load(input);
            daso.setDatabaseName(prop.getProperty("database"));
            daso.setServerName(prop.getProperty("serverName"));
            daso.setPort(Integer.parseInt(prop.getProperty("port")));
            daso.setUser(prop.getProperty("user"));
            daso.setPassword(prop.getProperty("password"));
        }

        // Exception occurs when file database.properties is not found or doesn't exist
        catch(FileNotFoundException e) {
            // For Simplicity just log the Exceptions
            LOGGER.log(Level.SEVERE, "File database.properties Not Found or doesn't exist", e);
        }

        // Exception occurs when thers is an I/O error
        catch(IOException e) {
            // For Simplicity just log the Exceptions
            LOGGER.log(Level.SEVERE, "I/O Error", e);
        } finally {
            if(input != null) {
                try {
                    input.close();
                }

                // Exception occurs when the app fails to close input streams
                catch (IOException e) {
                    // For Simplicity just log the Exceptions
                    LOGGER.log(Level.SEVERE, "I/O Error", e);
                }
            }
        }
        this.daso = daso;
    }

    public static Connection getConnection() throws SQLException{
        return SingletonHelper.INSTANCE.daso.getConnection();
    }

    private static class SingletonHelper{
        private static final DataSourceFactory INSTANCE = new DataSourceFactory();
    }
}