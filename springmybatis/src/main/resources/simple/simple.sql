
-- test
CREATE TABLE t_user (
  user_id char(32) NOT NULL,
  user_name varchar(30) DEFAULT NULL,
  user_birthday date DEFAULT NULL,
  user_salary double DEFAULT NULL,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE t_class (
  class_id char(32) NOT NULL,
  class_name varchar(30) DEFAULT NULL,
  PRIMARY KEY (class_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- test2
CREATE TABLE t_account (
  account_id char(32) NOT NULL,
  account_name varchar(30) DEFAULT NULL,
  PRIMARY KEY (account_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


