package com.company.name.storage;


import com.company.name.Base.DBHelper;

import javax.inject.Inject;

public class BaseDataPackage implements BaseDataRepo {


    private DBHelper dbHelper;

    @Inject
    public BaseDataPackage(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }


}
