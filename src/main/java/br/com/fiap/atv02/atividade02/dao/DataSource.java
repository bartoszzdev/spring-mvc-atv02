package br.com.fiap.atv02.atividade02.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import oracle.database.OracleDriver;

public class DataSource {
    private Connection connection;
    private String url;
    private String hostname;
    private String username;
    private String password;
    private String database;
    private int port;

    public DataSource() {
		try {
			DriverManager.registerDriver(new OracleDriver());
			hostname = "oracle.fiap.com.br";
			port     = 1521;
			username = "**seu usuario**";
			password = "**sua senha**";
			database = "**nome do seu SID**";
			url = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + database;
			connection = DriverManager.getConnection(url, username, password);

			if (connection != null) {
				System.out.println("Conectado com Sucesso");
			}
			else {
				System.out.println("Falhou na conexao");
			}
		}
		catch(Exception ex) {
			System.out.println("Datasource ERRO: " + ex.getMessage());
		}
	}

    public Connection getConnection() {
        return this.connection();
    }
}
