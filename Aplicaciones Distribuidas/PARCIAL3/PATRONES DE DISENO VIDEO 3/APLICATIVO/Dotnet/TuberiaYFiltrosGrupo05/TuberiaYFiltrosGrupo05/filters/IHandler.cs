using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TuberiaYFiltrosGrupo05.filters
{
    public interface IHandler<I, O>
    {
        public O Process(I input);
    }
}
