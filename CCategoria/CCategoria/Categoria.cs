using System;
namespace CCategoria
{
    public class Categoria
    {
		private ulong id;
		private string nombre;
        public Categoria() {
        }
		public Categoria(ulong id, string nombre) {
			this.id = id;
			this.nombre = nombre;
        }

		public ulong Id {
			get { return Id; }
			set { id = value; }
		}

		public string Nombre {
			get { return nombre; }
			set { nombre = value; }
		}

    }
}
