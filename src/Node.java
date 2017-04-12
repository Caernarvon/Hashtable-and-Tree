//Hashtable node to work with banking operations, includes getters and constructor.
public class Node<T1, T2> {
    private final T1 balance;
    private final T1 income;
    private final T1 outcome;
    private final T2 account;
    private final T2 txid;
    private  boolean deleted;

    public Node(T1 balance, T1 income, T1 outcome, T2 account, T2 txid) {
        this.balance = balance;
        this.income = income;
        this.outcome = outcome;
        this.account = account;
        this.txid = txid;
        this.deleted = false;
    }

    public T1 getBalance() {
        return balance;
    }

    public T1 getIncome() {
        return income;
    }

    public T1 getOutcome() {
        return outcome;
    }

    public T2 getAccount() {
        return account;
    }

    public T2 getTxid() {
        return txid;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public boolean deleteNode() {
        if(!this.deleted) {
            this.deleted = true;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return
                "\n" +
                "ballance=" + balance +
                        ", income=" + income +
                        ", outcome=" + outcome +
                        ", account=" + account +
                        ", txid=" + txid +
                ", deleted=" + deleted +
                '.';
    }
}
