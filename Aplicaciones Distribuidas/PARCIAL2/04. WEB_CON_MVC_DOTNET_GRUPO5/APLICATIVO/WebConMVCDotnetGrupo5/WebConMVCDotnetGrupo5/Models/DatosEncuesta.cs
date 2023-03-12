using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebConMVCDotnetGrupo5.Models
{
    public class DatosEncuesta
    {
        private string txtNombre;
        private string txtApellido;
        private string[] chkProgLeng;
        private string imgProfile;

        public string getTxtNombre()
        {
            return txtNombre;
        }

        public void setTxtNombre(string txtNombre)
        {
            this.txtNombre = txtNombre;
        }

        public string getTxtApellido()
        {
            return txtApellido;
        }

        public void setTxtApellido(string txtApellido)
        {
            this.txtApellido = txtApellido;
        }

        public string[] getChkProgLeng()
        {
            return chkProgLeng;
        }

        public void setChkProgLeng(string[] chkProgLeng)
        {
            this.chkProgLeng = chkProgLeng;
        }

        public string getImgProfile()
        {
            return imgProfile;
        }

        public void setImgProfile(string imgProfile)
        {
            this.imgProfile = imgProfile;
        }
    }
}
