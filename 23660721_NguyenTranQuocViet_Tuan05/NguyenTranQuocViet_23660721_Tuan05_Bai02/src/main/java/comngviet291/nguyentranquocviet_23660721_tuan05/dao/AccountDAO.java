package comngviet291.nguyentranquocviet_23660721_tuan05.dao;

import comngviet291.nguyentranquocviet_23660721_tuan05.model.Account;
import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class AccountDAO {
    private final DataSource dataSource;

    public List<Account> getAllAccounts() {
        String query = "SELECT ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, DATEOFBIRTH FROM Accounts";

        try (var connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            System.out.println("Database: " +
                    connection.getCatalog());

            System.out.println("URL: " +
                    connection.getMetaData().getURL());

            ResultSet resultSet = statement.executeQuery();

            List<Account> accounts = new ArrayList<>();

            while (resultSet.next()) {
                accounts.add(Account.builder()
                        .id(resultSet.getInt("ID"))
                        .firstName(resultSet.getString("FIRSTNAME"))
                        .lastName(resultSet.getString("LASTNAME"))
                        .password(resultSet.getString("PASSWORD"))
                        .email(resultSet.getString("EMAIL"))
                        .dateOfBirth(resultSet.getDate("DATEOFBIRTH"))
                        .build());
            }

            return accounts;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addAccount(Account account) {
        String query = "INSERT INTO Accounts ( FIRSTNAME, LASTNAME, EMAIL, PASSWORD, DATEOFBIRTH ) VALUES (?, ?, ?, ?, ?)";
        try (
                PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(query);
        ) {
            preparedStatement.setString(1, account.getFirstName());
            preparedStatement.setString(2, account.getLastName());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getEmail());
            preparedStatement.setDate(5, new java.sql.Date(account.getDateOfBirth().getTime()));
            return preparedStatement.executeUpdate() == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
