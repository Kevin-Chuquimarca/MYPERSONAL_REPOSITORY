using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TuberiaYFiltrosGrupo05.filters;

namespace TuberiaYFiltrosGrupo05.pipeline
{
    public class Pipeline<I, O>
    {
        private readonly IHandler<I, O> currentHandler;
        private Func<object, object> value;

        public Pipeline(IHandler<I, O> currentHandler)
        {
            this.currentHandler = currentHandler;
        }

        public Pipeline<I, K> AddHandler<K>(IHandler<O, K> newHandler)
        {
            return new Pipeline<I, K>(input => newHandler.Process(this.currentHandler.Process(input)));
        }

        public O Execute(I input)
        {
            return currentHandler.Process(input);
        }
    }

}
