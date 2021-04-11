#include "Operaciones.h"
#include "Nodo.h"
#include "PdfExamples.h"

void Operaciones::registrarPersona(ListaDoble<Persona>* lista) {
	Persona objPer;
	CalculoEdad objCalEdad;
	DireccionCorreo cr;
	Archivo<string> archivo;
	std::string nombre, apellido, cedula, correo;
	int edad = 0;
	nombre = objIngreso.IngresoTexto("Ingrese su nombre: ");
	apellido = objIngreso.IngresoTexto("Ingrese su apellido: ");
	objCalEdad.registrarEdad();
	edad = objCalEdad.getEdadAnios();
	cedula = objIngreso.IngresarCedula("Ingrese su cedula: ");
	correo = cr.generar_correo(nombre, apellido);
	if (lista->getPrimero() != NULL && cr.verificar_correos_rep(lista, correo)) {
		correo = cr.generar_correo(nombre, apellido);
	}
	lista->insertarFinal(objPer = Persona(nombre, apellido, edad, cedula, correo));
	archivo.escribirEnArchivo("Personas.txt",objPer.toString()+"\n");
	std::cout << "\nPersona Registrada" << std::endl;
}

void Operaciones::qrPersona(ListaDoble<Persona>* lista) {
	Persona objPer;
	GeneraQR qr;
	std::string cad;
	int num = 0;
	lista->imprimirLista();
	num = stoi(objIngreso.IngresoNumero("Ingrese el numero de persona: "));
	if (num > 0 && num <= lista->tamanio()) {
		objPer = lista->buscarNodoIzq(num)->getDato();
		cad = objPer.mostrarInformacion();
		qr.crear_QR(cad.c_str());
	}
}

void Operaciones::generarBackUp(ListaDoble<Persona>* lista) {
	Archivo<string> archivoBackUp;
	if (lista->getPrimero()) {
		archivoBackUp.generarBackUp();
		cout << "BackUp generado correctamente" << endl;
	}
	system("pause");
}

void Operaciones::generarPdf(ListaDoble<Persona>* lista) {
	if (lista->getPrimero()) {
		CreatePdf(lista);
		cout << "\nArchivo PDF generado correctamente" << endl;
	}
	system("pause");
}

void Operaciones::buscarDatos(ListaDoble<Persona>* lista) {
	Secuencial busqSecuencial;
	string cedulaAux;
	cout << "\nEscanear el codigo de barras de la cedula" << endl;
	cout << "De la persona de la cual se desean conocer los datos: ";
	cin >> cedulaAux;
	if (busqSecuencial.buscar(lista, cedulaAux) != true)
		cout << "No se encontraron coincidencias en la busqueda" << endl;
	system("pause");
}
