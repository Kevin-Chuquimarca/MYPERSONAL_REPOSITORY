using TuberiaYFiltrosGrupo05.filters;
using TuberiaYFiltrosGrupo05.pipeline;

Console.Write("Ingrese un valor: ");
string input = Console.ReadLine();

var filters = new Pipeline<string, char[]>(new RemoveAlphabetsHandler())
    .AddHandler(new RemoveDigitsHandler())
    .AddHandler(new ConvertToCharArrayHandler());

char[] result = filters.Execute(input);

foreach (char res in result)
{
    Console.WriteLine(res);
}