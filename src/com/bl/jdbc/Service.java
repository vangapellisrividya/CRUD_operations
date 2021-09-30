package com.bl.jdbc;

import java.sql.Connection;

public interface Service {
	abstract void select(Connection con) ;

	abstract void create(Connection con) ;

	abstract void delete(Connection con) ;

	abstract void update(Connection con) ;

	abstract void average(Connection con);

	abstract void insert(Connection con);
}
