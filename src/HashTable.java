interface HashTable3<T1, T2> {
    public  boolean push(T1 balance, T1 income,T1 outcome, T2 account, T2 txid);
    public  boolean delete(T2 account);
    public  T2 get(T2 account);
}
