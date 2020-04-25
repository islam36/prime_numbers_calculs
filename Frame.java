
import javax.swing.JOptionPane;


public class Frame extends javax.swing.JFrame {

    
    public boolean isPrime(long n)
    {
        boolean prime=true;
        long i=2;
        
        if(n<=1)
            prime=false;
        else 
        {
            
            while (i<= n-1 && prime)
            {
                if(n%i==0)
                    prime=false;
                i++;
                    
            }
        }
        
        return prime;
    }

    public String primeFactor(long n)
    {
        long p=2;
        String result="";
        
        while(n>= p*p)
        {
            if(n%p==0)
            {
               result+=String.valueOf(p) + " X ";
               n/=p;
               if(result.length()== 100)
                   result+="\n";
            }
            else
                p++;
        }
        
        result+=String.valueOf(n);
        
        return result;
    }
    
    public String prePrimes(long n)
    {
        String result="";
        int i=0,j=0;
        
        while(i<n)
        {
            if(isPrime(i))
            {
                result+=String.valueOf(i) + " ; ";
                
               
            }
            
            j++;
              if(j>=100)
                {
                    result+="\n";
                    j=0;
                } 
            i++;
            
        }
        
        return result.substring(0, result.length()-2);
    }
    
    public Frame() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        getN = new javax.swing.JFormattedTextField();
        isPrime_b = new javax.swing.JRadioButton();
        primeFactor_b = new javax.swing.JRadioButton();
        prePrimes_b = new javax.swing.JRadioButton();
        ok_b = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prime numbers' calculs");
        setAlwaysOnTop(true);
        setResizable(false);

        getN.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getN.setToolTipText("Enter a non null positive integer");
        getN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        buttonGroup1.add(isPrime_b);
        isPrime_b.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        isPrime_b.setSelected(true);
        isPrime_b.setText("Check if the number is prime");

        buttonGroup1.add(primeFactor_b);
        primeFactor_b.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        primeFactor_b.setText("Calcul prime factor");

        buttonGroup1.add(prePrimes_b);
        prePrimes_b.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        prePrimes_b.setText("Print precedent primes");

        ok_b.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ok_b.setText("OK");
        ok_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_bActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isPrime_b)
                            .addComponent(getN, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(primeFactor_b)
                            .addComponent(prePrimes_b)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(ok_b)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(getN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(isPrime_b)
                .addGap(18, 18, 18)
                .addComponent(primeFactor_b)
                .addGap(18, 18, 18)
                .addComponent(prePrimes_b)
                .addGap(27, 27, 27)
                .addComponent(ok_b)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void ok_bActionPerformed(java.awt.event.ActionEvent evt) {                                     
    long n;
    
    if(getN.getText().isEmpty())
    {
        JOptionPane.showMessageDialog(rootPane, "Please enter a positive integer", "Error",0);
    }
    else 
    {
        n=Long.parseLong(getN.getText());
        
        if(n<0)
        {
               JOptionPane.showMessageDialog(rootPane, "Please enter a positive integer", "Error",0);
        }
        else
        {
        
        if(isPrime_b.isSelected())
        {
            if(isPrime(n))
            {
                JOptionPane.showMessageDialog(rootPane,String.valueOf(n) + " is prime", "Result",1);
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane,String.valueOf(n) + " is not prime", "Result",1);
            }
        }
        else if(primeFactor_b.isSelected())
        {
            if(isPrime(n))
            {
                JOptionPane.showMessageDialog(rootPane, String.valueOf(n) + " is prime and hasn't prime factor", "Result",1);
            }
            else
            {
            JOptionPane.showMessageDialog(rootPane,String.valueOf(n) + " = " + primeFactor(n), "Result",1);
            }
            
        }
        else if(prePrimes_b.isSelected())
        {
            if(n>2)
            {
            JOptionPane.showMessageDialog(rootPane,"Precedent primes are:\n" + prePrimes(n), "Result",1);
            }
            else
            {
             JOptionPane.showMessageDialog(rootPane, "There are no precedent primes", "Result",1);
            }
        
        }
        }
    }
    
    }                                    


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField getN;
    private javax.swing.JRadioButton isPrime_b;
    private javax.swing.JButton ok_b;
    private javax.swing.JRadioButton prePrimes_b;
    private javax.swing.JRadioButton primeFactor_b;
    // End of variables declaration                   
}

