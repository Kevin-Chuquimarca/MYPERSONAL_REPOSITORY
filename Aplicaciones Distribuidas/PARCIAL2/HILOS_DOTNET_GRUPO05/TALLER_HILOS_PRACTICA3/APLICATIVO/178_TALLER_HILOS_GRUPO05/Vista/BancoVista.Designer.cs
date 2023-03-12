namespace _178_TALLER_HILOS_GRUPO05.Vista
{
    partial class BancoVista
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
            this.txtPrint = new System.Windows.Forms.TextBox();
            this.btnSalir = new System.Windows.Forms.Button();
            this.btnEmpezar = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // txtPrint
            // 
            this.txtPrint.BackColor = System.Drawing.Color.LightYellow;
            this.txtPrint.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.txtPrint.ForeColor = System.Drawing.Color.Black;
            this.txtPrint.Location = new System.Drawing.Point(170, 24);
            this.txtPrint.Margin = new System.Windows.Forms.Padding(4);
            this.txtPrint.Multiline = true;
            this.txtPrint.Name = "txtPrint";
            this.txtPrint.ReadOnly = true;
            this.txtPrint.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.txtPrint.Size = new System.Drawing.Size(359, 518);
            this.txtPrint.TabIndex = 3;
            this.txtPrint.TextChanged += new System.EventHandler(this.txtPrint_TextChanged);
            // 
            // btnSalir
            // 
            this.btnSalir.BackColor = System.Drawing.Color.LightPink;
            this.btnSalir.Font = new System.Drawing.Font("Brush Script MT", 12F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSalir.ForeColor = System.Drawing.Color.Black;
            this.btnSalir.Location = new System.Drawing.Point(572, 246);
            this.btnSalir.Margin = new System.Windows.Forms.Padding(4);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(101, 39);
            this.btnSalir.TabIndex = 7;
            this.btnSalir.Text = "Detener";
            this.btnSalir.UseVisualStyleBackColor = false;
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // btnEmpezar
            // 
            this.btnEmpezar.BackColor = System.Drawing.Color.LightBlue;
            this.btnEmpezar.Font = new System.Drawing.Font("Brush Script MT", 12F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEmpezar.ForeColor = System.Drawing.Color.Black;
            this.btnEmpezar.Location = new System.Drawing.Point(36, 246);
            this.btnEmpezar.Margin = new System.Windows.Forms.Padding(4);
            this.btnEmpezar.Name = "btnEmpezar";
            this.btnEmpezar.Size = new System.Drawing.Size(85, 39);
            this.btnEmpezar.TabIndex = 6;
            this.btnEmpezar.Text = "Iniciar";
            this.btnEmpezar.UseVisualStyleBackColor = false;
            this.btnEmpezar.Click += new System.EventHandler(this.btnEmpezar_Click);
            // 
            // BancoVista
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.LightSalmon;
            this.ClientSize = new System.Drawing.Size(709, 572);
            this.Controls.Add(this.btnSalir);
            this.Controls.Add(this.btnEmpezar);
            this.Controls.Add(this.txtPrint);
            this.Name = "BancoVista";
            this.Text = "BancoVista";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtPrint;
        private System.Windows.Forms.Button btnSalir;
        private System.Windows.Forms.Button btnEmpezar;
    }
}