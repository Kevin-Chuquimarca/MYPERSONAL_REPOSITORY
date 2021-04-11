#include "Operaciones.h"
#include "Nodo.h"
#include "PdfExamples.h"

void Operaciones::registrarPersona(ListaCircular<Persona>* lista) {
	Persona objPer;
	CalculoEdad objCalEdad;
	DireccionCorreo cr;
	std::string nombre, apellido, cedula, correo;
	int edad = 0;
	nombre = objIngreso.IngresoTexto("Ingrese su nombre: ");
	apellido = objIngreso.IngresoTexto("Ingrese su apellido: ");
	objCalEdad.registrarEdad();
	edad = objCalEdad.getEdadAnios();
	cedula = objIngreso.IngresarCedula("Ingrese su cedula: ");
	correo = cr.generarCorreo(nombre, apellido);
	if (lista->getPrimero() != NULL && cr.verificarCorreosRep(lista, correo)) {
		correo = cr.generarCorreo(nombre, apellido);
	}
	lista->insertarFinal(objPer = Persona(nombre, apellido, edad, cedula, correo));
	std::cout << "\nPersona Registrada" << std::endl;
}

void Operaciones::qrPersona(ListaCircular<Persona>* lista) {
	Persona objPer;
	GeneraQR qr;
	std::string cad;
	int num = 0;
	lista->imprimir();
	num = stoi(objIngreso.IngresoNumero("Ingrese el numero de persona: "));
	if (num > 0 && num <= lista->tamanio()) {
		objPer = lista->buscar(num)->getDato();
		cad = objPer.mostrarInformacion();
		qr.crear_QR(cad.c_str());
	}
}

void Operaciones::generarBackUp(ListaCircular<Persona>* lista) {
	Archivo<string> archivoBackUp;
	if (lista->getPrimero()->getDato().getNombre() == "")
		cout << "La lista no contiene elementos guardados" << endl;
	else
	{
		Nodo<Persona>* aux;
		aux = lista->getPrimero();
		while (aux != lista->getUltimo()) {
			archivoBackUp.escribirEnArchivo("PersonasLC.txt", aux->getDato().toString() + "\n");
			aux = aux->getSiguiente();
		}
		archivoBackUp.generarBackUp();
		cout << "BackUp generado correctamente" << endl;
	}
	system("pause");
}

void Operaciones::generarPdf(ListaCircular<Persona>* lista) {
	if (lista->getPrimero()->getDato().getNombre() == "")
		cout << "La lista no contiene elementos guardados" << endl;
	else
	{
		CreatePdf(lista);
		cout << "\nArchivo PDF generado correctamente" << endl;
	}
	system("pause");
}

void Operaciones::buscarDatos(ListaCircular<Persona>* lista) {
	Secuencial busqSecuencial;
	string cedulaAux;
	cout << "\nEscanear el codigo de barras de la cedula" << endl;
	cout << "De la persona de la cual se desean conocer los datos: ";
	cin >> cedulaAux;
	if (busqSecuencial.buscar(lista, cedulaAux) != true)
		cout << "No se encontraron coincidencias en la busqueda" << endl;
	system("pause");
}
