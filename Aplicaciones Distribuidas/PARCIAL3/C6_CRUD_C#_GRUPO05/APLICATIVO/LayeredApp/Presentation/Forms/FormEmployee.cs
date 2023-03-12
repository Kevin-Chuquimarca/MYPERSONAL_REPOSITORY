using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Domain.Models;
using Domain.ValueObjects;


namespace Presentation.Forms
{
    public partial class FormEmployee : Form
    {
        private EmployeeModel employee = new EmployeeModel();

        public FormEmployee()
        {
            InitializeComponent();
            panel1.Enabled = false;
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void FormEmployee_Load(object sender, EventArgs e)
        {
            ListEmployees();
        }

        private void ListEmployees()
        {
            try
            {
                dgvEmployee.DataSource = employee.GetAll();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString());
            }
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            dgvEmployee.DataSource = employee.FindById(txtSearch.Text);
        }

        private void txtSearch_TextChanged(object sender, EventArgs e)
        {
            dgvEmployee.DataSource = employee.FindById(txtSearch.Text);
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            employee.IdNumber = txtID.Text;
            employee.Mail = txtEmail.Text;
            employee.Name = txtName.Text;
            employee.Birthday = dtpBirthday.Value;

            bool valid = new Helps.DataValidation(employee).Validate();
            if(valid == true)
            {
                string result = employee.SaveChanges();
                MessageBox.Show(result);
                ListEmployees();
                Restart();
            }
        }

        private void Restart()
        {
            panel1.Enabled = false;
            txtEmail.Clear();  
            txtID.Clear();
            txtName.Clear();
        }


        private void btnNew_Click(object sender, EventArgs e)
        {
            panel1.Enabled = true;
            employee.State = EntityState.Added;
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            if(dgvEmployee.SelectedRows.Count > 0)
            {
                panel1.Enabled = true;
                employee.State = EntityState.Modified;
                employee.IdPk = Convert.ToInt32(dgvEmployee.CurrentRow.Cells[0].Value);
                txtID.Text = dgvEmployee.CurrentRow.Cells[1].Value.ToString();
                txtName.Text = dgvEmployee.CurrentRow.Cells[2].Value.ToString();
                txtEmail.Text = dgvEmployee.CurrentRow.Cells[3].Value.ToString();
                dtpBirthday.Value = Convert.ToDateTime(dgvEmployee.CurrentRow.Cells[4].Value);
            }
            else
            {
                MessageBox.Show("Selecet row");
            }
        }

        private void btnRemove_Click(object sender, EventArgs e)
        {
            if (dgvEmployee.SelectedRows.Count > 0)
            {
                employee.State = EntityState.Deleted;
                employee.IdPk = Convert.ToInt32(dgvEmployee.CurrentRow.Cells[0].Value);
                string result = employee.SaveChanges();
                MessageBox.Show(result);
                ListEmployees();
            }
            else
            {
                MessageBox.Show("Selecet row");
            }
        }
    }
}
