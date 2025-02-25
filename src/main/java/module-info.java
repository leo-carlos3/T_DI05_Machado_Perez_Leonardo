module machado.leonardo.t_di05_machado_perez_leonardo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires net.sf.jasperreports.core;
    requires com.fasterxml.jackson.dataformat.xml;
    requires java.management;

    opens machado.leonardo.t_di05_machado_perez_leonardo to javafx.fxml;
    exports machado.leonardo.t_di05_machado_perez_leonardo;
}