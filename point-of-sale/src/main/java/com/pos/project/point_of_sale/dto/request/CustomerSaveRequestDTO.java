package com.pos.project.point_of_sale.dto.request;

public class CustomerSaveRequestDTO {

        private String customerName;
        private String customerAddress;
        private double customerSalary;
        private int contactNumbers;
        private String nic;

        public CustomerSaveRequestDTO(){

        }

        public CustomerSaveRequestDTO(int customerId, String customerName, String customerAddress, double customerSalary, int contactNumbers, String nic, boolean activeState) {

            this.customerName = customerName;
            this.customerAddress = customerAddress;
            this.customerSalary = customerSalary;
            this.contactNumbers = contactNumbers;
            this.nic = nic;
        }



        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerAddress() {
            return customerAddress;
        }

        public void setCustomerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
        }

        public double getCustomerSalary() {
            return customerSalary;
        }

        public void setCustomerSalary(double customerSalary) {
            this.customerSalary = customerSalary;
        }

        public int getContactNumbers() {
            return contactNumbers;
        }

        public void setContactNumbers(int contactNumbers) {
            this.contactNumbers = contactNumbers;
        }

        public String getNic() {
            return nic;
        }

        public void setNic(String nic) {
            this.nic = nic;
        }


    }


