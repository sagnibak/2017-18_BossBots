package org.firstinspires.ftc.teamcode;

public @interface Contributions {
    String[] ModifiedBy();  // names of people who modified the code; lsat name is latest
    String LastModifiedOn();  // date on which the code was last modified
}
