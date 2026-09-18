package comngviet291.nguyentranquocviet_23660721_tuan05.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AccountUtil {

    private static final DataSource DATA_SOURCE;

    static {
        try {
            InitialContext context = new InitialContext();

            DATA_SOURCE = (DataSource) context.lookup(
                    "java:comp/env/jdbc/storedb"
            );

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    private AccountUtil() {
    }

    public static DataSource getDataSource() {
        return DATA_SOURCE;
    }
}