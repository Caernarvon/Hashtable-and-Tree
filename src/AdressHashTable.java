import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdressHashTable<T1, T2> implements HashTable3<T1, T2> {
    private Node<T1, T2>[] table;
    private final int DEFAULT_SIZE = 11000;

    public AdressHashTable() {
        this.table = new Node[DEFAULT_SIZE];
    }

    public boolean push(T1 balance, T1 income, T1 outcome, T2 account, T2 txid) {
        //table[getHash(account)] = new Node<T1,T2,T3,T4,T5>(balance, income, outcome, account, txid);
        //return true;

        int h = getHash(account);
        int i = 0;

        if(table[h] == null || table[h].isDeleted()) {
            table[h] = new Node<T1, T2>(balance, income, outcome, account, txid);
            return true;
        }

        for(i = h + 1; i != h; i = (i + 1) % table.length) {
            if(table[i] == null || table[i].isDeleted() || table[i].getAccount() == account) {
                table[i] = new Node<T1, T2>(balance, income, outcome, account, txid);
                return true;
            }
        }
        if(table[h] != null) {
            while(table[h] != null) {
                h++;
            }
            table[h] = new Node<T1, T2>(balance, income, outcome, account, txid);
            return true;
        }


        return false;

    }

    public boolean delete(T2 account) {
        int h = getHash(account);
        if(table[h] != null && table[h].getAccount() == account) {
            table[h].deleteNode();
            return true;
        }

        for(int i = h + 1; i != h; i = (i + 1) % table.length) {
            if(table[i] != null && (table[i].getAccount() == account && !table[i].isDeleted())) {
                table[i].deleteNode();
                return true;
            }
        }

        return false;
    }

    public T2 get(T2 account) {
        int h = getHash(account);
        if (table[h] != null && table[h].getAccount() == account && !table[h].isDeleted()) {
            return table[h].getAccount();
        }


        for (int i = h + 1; i != h; i = (i + 1) % table.length) {
            if(table[i] != null && (table[i].getAccount() == account && !table[i].isDeleted())) {
                return table[h].getAccount();
            }
        }

        return null;
    }

    public int getHash(T2 account) {
        int result = 0;
        if (account instanceof BigDecimal) {
            result = (Integer) account;
        }
        return result;
    }

    @Override
    public String toString() {
        return "AdressHashTable{" +
                "table=" + Arrays.toString(table) +
                ", DEFAULT_SIZE=" + DEFAULT_SIZE +
                '}';
    }
}
