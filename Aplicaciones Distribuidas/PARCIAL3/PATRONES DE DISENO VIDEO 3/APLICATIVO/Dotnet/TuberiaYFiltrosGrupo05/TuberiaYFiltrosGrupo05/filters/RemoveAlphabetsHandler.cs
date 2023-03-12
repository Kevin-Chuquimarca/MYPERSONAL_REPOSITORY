using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace TuberiaYFiltrosGrupo05.filters
{
    public class RemoveAlphabetsHandler : IHandler<string, string>
    {
        public string Process(string input)
        {
            return Regex.Replace(input, "[a-zA-Z]", "");
        }
    }

}
