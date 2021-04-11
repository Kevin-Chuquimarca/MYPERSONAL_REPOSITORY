#include "Aspose.Pdf.h"
#include "ListaDoble.h"
#include "Persona.h"
using namespace System;
using namespace Aspose::Pdf;
using namespace Aspose::Pdf::Text;

void CreatePdf(ListaDoble<Persona>* lista)
{
	// ExStart:CreatePdf	
	auto doc = MakeObject<Document>();
	auto pages = doc->get_Pages();
	pages->Add();
	// Numeration of Pages starts from 1
	auto page = pages->idx_get(1);
	auto paragraps = page->get_Paragraphs();
	
	std::string cadena1;
	Nodo<Persona>* aux;
	aux = lista->getPrimero();
	while (aux != NULL) {
		cadena1 = aux->getDato().toString();
		String cadena = String(cadena1);
		paragraps->Add(MakeObject<TextFragment>(cadena));
		aux = aux->getSiguiente();
	}

	auto text = MakeObject<TextFragment>(u"Fin del documento");
	auto ts = text->get_TextState();

	ts->set_FontSize(16);
	ts->set_FontStyle(FontStyles::Italic);
	paragraps->Add(text);

	doc->Save(u"C:\\Users\\Usuario\\source\\repos\\Kevin-Chuquimarca\\Proyecto_Parcial2\\Codigo\\Proyecto\\Proyecto\\Personas.pdf");
	// ExEnd:CreatePdf
	Console::WriteLine(u"Pdf file created successfully.");
}
