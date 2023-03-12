namespace _168_TALLER_HILOS_GRUPO05.vista
{
    partial class PelotaVista
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.pnlPelotas = new System.Windows.Forms.Panel();
            this.btnDale = new System.Windows.Forms.Button();
            this.btnSalir = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // pnlPelotas
            // 
            this.pnlPelotas.BackColor = System.Drawing.SystemColors.ActiveBorder;
            this.pnlPelotas.Location = new System.Drawing.Point(4, 4);
            this.pnlPelotas.Name = "pnlPelotas";
            this.pnlPelotas.Size = new System.Drawing.Size(757, 404);
            this.pnlPelotas.TabIndex = 0;
            // 
            // btnDale
            // 
            this.btnDale.Location = new System.Drawing.Point(299, 425);
            this.btnDale.Name = "btnDale";
            this.btnDale.Size = new System.Drawing.Size(75, 23);
            this.btnDale.TabIndex = 1;
            this.btnDale.Text = "Dale!";
            this.btnDale.UseVisualStyleBackColor = true;
            // 
            // btnSalir
            // 
            this.btnSalir.Location = new System.Drawing.Point(395, 426);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(75, 23);
            this.btnSalir.TabIndex = 2;
            this.btnSalir.Text = "Salir";
            this.btnSalir.UseVisualStyleBackColor = true;
            // 
            // PelotaVista
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(765, 461);
            this.Controls.Add(this.btnSalir);
            this.Controls.Add(this.btnDale);
            this.Controls.Add(this.pnlPelotas);
            this.Name = "PelotaVista";
            this.Text = "PelotaVista";
            this.ResumeLayout(false);

        }

        #endregion

        private Panel pnlPelotas;
        private Button btnDale;
        private Button btnSalir;
    }
}