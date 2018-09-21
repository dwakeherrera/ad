using System;
using Gtk;
using MySql.Data.MySqlClient;
using System.Data;

public partial class MainWindow : Gtk.Window
{
    public MainWindow() : base(Gtk.WindowType.Toplevel)
    {
        Build();

		IDbConnection dbConnection = new MySqlConnection(
                "server=localhost;database=dbprueba;user=root;password=sistemas;ssl-mode=none"
            );
        dbConnection.Open();

		treeView.AppendColumn("ID", new CellRendererText(), "text", 0);
        treeView.AppendColumn("Nombre", new CellRendererText(), "text", 1);

		//ListStore listStore = new ListStore(typeof(ulong), typeof(string)); //Ejemplo ulong
		ListStore listStore = new ListStore(typeof(string), typeof(string));// ToString en dataReader
        treeView.Model = listStore;

		IDbCommand dbCommand = dbConnection.CreateCommand();
        dbCommand.CommandText = "select id, nombre from categoria order by id";
		IDataReader dataReader = dbCommand.ExecuteReader();
		while (dataReader.Read()) //Método Luis
			listStore.AppendValues(dataReader["id"].ToString(), dataReader["nombre"].ToString());
		//for (int index = 0; index < dataReader.FieldCount; index++) //Método Rafa
		//treeView.AppendColumn(dataReader.GetName(index), new CellRendererText(), "text", index);


		//listStore.AppendValues("1", "cat 1");
		//listStore.AppendValues("2", "cat 2");

		dataReader.Close();
		dbConnection.Close();
    }

    protected void OnDeleteEvent(object sender, DeleteEventArgs a)
    {
        Application.Quit();
        a.RetVal = true;
    }
}
