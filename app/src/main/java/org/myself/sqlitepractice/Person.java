package org.myself.sqlitepractice;

public class Person {
    int _id;
    String _name;
    String _password;

    public Person(){}

    public Person(int id, String name, String password){
        this._id=id;
        this._name=name;
        this._password=password;
    }

    public Person(String name, String password){
        this._name=name;
        this._password=password;
    }

    public int get_id(){return this._id;}
    public String get_name(){return this._name;}
    public String get_password(){return this._password;}

    public void set_id(int id){this._id=id;}
    public void set_name(String name){this._name=name;}
    public void set_password(String password){this._password=password;}

}
