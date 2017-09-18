package org.firstinspires.ftc.teamcode;

public @interface Contributions {
    String[] ModifiedBy();  // names of people who modified the code; last name is latest
    String LastModifiedOn();  // date on which the code was last modified
}
