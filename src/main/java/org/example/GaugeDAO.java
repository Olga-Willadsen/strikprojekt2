package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GaugeDAO {

    private DBConnector dbConnector;

public GaugeDAO (DBConnector dbConnector){
    this.dbConnector=dbConnector;
}


public void createTable()throws SQLException {

    String sql = """
                CREATE TABLE IF NOT EXISTS gauges (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    yarn_name TEXT NOT NULL,
                    needle_size DOUBLE NOT NULL,
                    stitches DOUBLE NOT NULL,
                    rows DOUBLE NOT NULL,
                    UNIQUE (yarn_name, needle_size)
                );
                """;
    //der er ikke mulighed for to gaugeswatches af samme garn på samme pind,
    // men bruger skal redirectes til at opdatere eksisterende swatch

    try (
            Connection conn = dbConnector.getConnection();
            Statement stmt = conn.createStatement()
    ) {
        stmt.execute(sql);
    }
}

public void insertGauge (Gauge gauge) throws SQLException {
    String sql= "INSERT INTO gauges (yarn_name, needle_size, stitches, rows) VALUES(?,?,?,?)";

    try (
        Connection conn = dbConnector.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
    ) {
        ps.setString(1, gauge.getYarnName());
        ps.setDouble(2, gauge.getNeedleSize());
        ps.setDouble(3, gauge.getStitches());
        ps.setDouble(4, gauge.getRows());

        ps.executeUpdate();

    }
}

public List<Gauge> findAll ()throws SQLException{
    String sql="SELECT id, yarn_name, needle_size, stitches, rows FROM gauges";
    List <Gauge> gauges = new ArrayList<>();

    try(
            Connection conn= dbConnector.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            ){
        while (rs.next()){
            gauges.add(new Gauge(rs.getInt("id"),
                    rs.getString("yarn_name"), rs.getDouble("needle_size"),
                    rs.getDouble("stitches"), rs.getDouble("rows")));
        }
    }

    return gauges;
}

public Gauge findByID (int id)throws SQLException{
    Gauge gauge;

    String sql= "SELECT id, yarn_name, needle_size, stitches, rows FROM gauges WHERE id = ?";

    try(
            Connection conn = dbConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            gauge = new Gauge(rs.getInt("id"),rs.getString("yarn_name"), rs.getDouble("needle_size"),
                    rs.getDouble("stitches"), rs.getDouble("rows"));
            return gauge;
        }
    }
    return null;
}

public void updateGauge (Gauge gauge)throws SQLException{
    Gauge g=gauge;
    String sql ="UPDATE gauges SET yarn_name = ?, needle_size = ?, stitches = ?, rows = ? WHERE id = ?";

    try(
            Connection conn = dbConnector.getConnection();
            PreparedStatement ps =conn.prepareStatement(sql);
            ) {
            ps.setString(1, g.getYarnName());
            ps.setDouble(2, g.getNeedleSize());
            ps.setDouble(3, g.getStitches());
            ps.setDouble(4, g.getRows());
            ps.setInt(5, g.getId());

            ps.executeUpdate();

    }
}

public void deleteGauge (Gauge gauge)throws SQLException {
    String sql ="DELETE FROM gauges WHERE id = ?";
    Gauge g=gauge;

    try(
            Connection conn = dbConnector.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ){
        ps.setInt(1, g.getId());
        ps.executeUpdate();
    }
}



}
