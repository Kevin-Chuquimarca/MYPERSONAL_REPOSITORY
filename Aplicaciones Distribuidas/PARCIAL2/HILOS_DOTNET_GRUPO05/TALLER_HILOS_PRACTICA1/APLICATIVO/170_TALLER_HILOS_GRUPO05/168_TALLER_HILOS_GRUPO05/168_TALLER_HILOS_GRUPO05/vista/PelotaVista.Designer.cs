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
            this.btnPelota1 = new System.Windows.Forms.Button();
            this.btnSalir = new System.Windows.Forms.Button();
            this.btnPausar1 = new System.Windows.Forms.Button();
            this.btnPelota2 = new System.Windows.Forms.Button();
            this.btnPelota3 = new System.Windows.Forms.Button();
            this.btnPausar2 = new System.Windows.Forms.Button();
            this.btnPausar3 = new System.Windows.Forms.Button();
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
            // btnPelota1
            // 
            this.btnPelota1.Location = new System.Drawing.Point(51, 426);
            this.btnPelota1.Name = "btnPelota1";
            this.btnPelota1.Size = new System.Drawing.Size(75, 23);
            this.btnPelota1.TabIndex = 1;
            this.btnPelota1.Text = "Pelota 1";
            this.btnPelota1.UseVisualStyleBackColor = true;
            // 
            // btnSalir
            // 
            this.btnSalir.Location = new System.Drawing.Point(646, 426);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(75, 23);
            this.btnSalir.TabIndex = 2;
            this.btnSalir.Text = "Salir";
            this.btnSalir.UseVisualStyleBackColor = true;
            // 
            // btnPausar1
            // 
            this.btnPausar1.Location = new System.Drawing.Point(349, 426);
            this.btnPausar1.Name = "btnPausar1";
            this.btnPausar1.Size = new System.Drawing.Size(75, 23);
            this.btnPausar1.TabIndex = 3;
            this.btnPausar1.Text = "Pausar 1";
            this.btnPausar1.UseVisualStyleBackColor = true;
            // 
            // btnPelota2
            // 
            this.btnPelota2.Location = new System.Drawing.Point(145, 426);
            this.btnPelota2.Name = "btnPelota2";
            this.btnPelota2.Size = new System.Drawing.Size(75, 23);
            this.btnPelota2.TabIndex = 4;
            this.btnPelota2.Text = "Pelota 2";
            this.btnPelota2.UseVisualStyleBackColor = true;
            // 
            // btnPelota3
            // 
            this.btnPelota3.Location = new System.Drawing.Point(244, 426);
            this.btnPelota3.Name = "btnPelota3";
            this.btnPelota3.Size = new System.Drawing.Size(75, 23);
            this.btnPelota3.TabIndex = 5;
            this.btnPelota3.Text = "Pelota 3";
            this.btnPelota3.UseVisualStyleBackColor = true;
            // 
            // btnPausar2
            // 
            this.btnPausar2.Location = new System.Drawing.Point(450, 426);
            this.btnPausar2.Name = "btnPausar2";
            this.btnPausar2.Size = new System.Drawing.Size(75, 23);
            this.btnPausar2.TabIndex = 6;
            this.btnPausar2.Text = "Pausar 2";
            this.btnPausar2.UseVisualStyleBackColor = true;
            // 
            // btnPausar3
            // 
            this.btnPausar3.Location = new System.Drawing.Point(551, 426);
            this.btnPausar3.Name = "btnPausar3";
            this.btnPausar3.Size = new System.Drawing.Size(75, 23);
            this.btnPausar3.TabIndex = 7;
            this.btnPausar3.Text = "Pausar 3";
            this.btnPausar3.UseVisualStyleBackColor = true;
            // 
            // PelotaVista
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(765, 461);
            this.Controls.Add(this.btnPausar3);
            this.Controls.Add(this.btnPausar2);
            this.Controls.Add(this.btnPelota3);
            this.Controls.Add(this.btnPelota2);
            this.Controls.Add(this.btnPausar1);
            this.Controls.Add(this.btnSalir);
            this.Controls.Add(this.btnPelota1);
            this.Controls.Add(this.pnlPelotas);
            this.Name = "PelotaVista";
            this.Text = "PelotaVista";
            this.ResumeLayout(false);

        }

        #endregion

        private Panel pnlPelotas;
        private Button btnPelota1;
        private Button btnPausar1;
        private Button btnPelota2;
        private Button btnPelota3;
        private Button btnPausar2;
        private Button btnPausar3;
        private Button btnSalir;
    }
}