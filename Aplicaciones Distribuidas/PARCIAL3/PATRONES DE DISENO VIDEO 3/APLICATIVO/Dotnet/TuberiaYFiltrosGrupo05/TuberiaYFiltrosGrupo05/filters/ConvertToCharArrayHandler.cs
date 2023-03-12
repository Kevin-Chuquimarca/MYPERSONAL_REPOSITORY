using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TuberiaYFiltrosGrupo05.filters
{
    public class ConvertToCharArrayHandler : IHandler<string, char[]>
    {
        public char[] Process(string input)
        {
            char[] charArray = new char[input.Length];
            for (int i = 0; i < input.Length; i++)
            {
                charArray[i] = input[i];
            }
            return charArray;
        }
    }

}
