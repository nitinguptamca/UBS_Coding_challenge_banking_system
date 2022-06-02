package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;
    private static long accountNumber = 1L;


    public Bank() {
        accounts = new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
        return accounts.entrySet().stream().filter(e -> e.getKey() == accountNumber)
                .map(entry -> entry.getValue()).findFirst().get();
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        accountNumber++;
        accounts.put(accountNumber, new CommercialAccount(company, accountNumber, pin, startingDeposit));
        return accountNumber;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        accountNumber++;
        accounts.put(accountNumber, new ConsumerAccount(person, accountNumber, pin, startingDeposit));
        return accountNumber;
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        Account account = accounts.get(accountNumber);
        return account.validatePin(pin);
    }

    public double getBalance(Long accountNumber) {
        return accounts.get(accountNumber).getBalance();


    }

    public void credit(Long accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        account.creditAccount(amount);
        accounts.put(accountNumber, account);
    }

    public boolean debit(Long accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account.getBalance() >= amount) {
            account.debitAccount(amount);
            accounts.put(accountNumber, account);
            return true;
        }else {
			return account.getBalance() >= amount;
		}
    }
}
