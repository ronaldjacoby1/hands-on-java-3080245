package bank;

import javax.security.auth.login.LoginException;

public class Authenticator {
  public static Customer login(String username, String password) throws LoginException {
    Customer customer = DataSource.getCustomer(username);
    if (customer == null) {
      throw new LoginException("Username Not Found");
    }

    if (password.equals(customer.getPassword())) {
      customer.setAuthenticated(true);
      return Customer;
    } else throw new LoginException("Incorrect Password");
  }

  public static void logout(Customer customer) {
    customer.setAuthenticated(false);
  }
}
