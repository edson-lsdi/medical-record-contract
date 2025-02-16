export FABRIC_CA_CLIENT_HOME=/etc/hyperledger/fabric-ca-server/fabric-ca/clients/admin

#admin
fabric-ca-client enroll -u https://admin:adminpw@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem

#add affiliation
fabric-ca-client affiliation add medico -u https://admin:adminpw@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem
fabric-ca-client affiliation add enfermeiro -u https://admin:adminpw@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem
fabric-ca-client affiliation add paciente -u https://admin:adminpw@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem

#medico
fabric-ca-client register --id.name maria --id.secret 111 -u https://admin:adminpw@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem --id.affiliation medico
fabric-ca-client enroll -u https://maria:111@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem --home /etc/hyperledger/fabric-ca-server/fabric-ca/clients/user1/ 

fabric-ca-client register --id.name eduarda --id.secret 111 -u https://admin:adminpw@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem --id.affiliation medico
fabric-ca-client enroll -u https://eduarda:111@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem --home /etc/hyperledger/fabric-ca-server/fabric-ca/clients/user2/

#enfermeiro
fabric-ca-client register --id.name carlos --id.secret 111 -u https://admin:adminpw@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem --id.affiliation enfermeiro
fabric-ca-client enroll -u https://carlos:111@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem --home /etc/hyperledger/fabric-ca-server/fabric-ca/clients/user3/

fabric-ca-client register --id.name eduardo --id.secret 111 -u https://admin:adminpw@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem --id.affiliation enfermeiro
fabric-ca-client enroll -u https://eduardo:111@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem --home /etc/hyperledger/fabric-ca-server/fabric-ca/clients/user4/

#paciente
fabric-ca-client register --id.name miguel --id.secret 111 -u https://admin:adminpw@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem --id.affiliation paciente
fabric-ca-client enroll -u https://miguel:111@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem --home /etc/hyperledger/fabric-ca-server/fabric-ca/clients/user5/

fabric-ca-client register --id.name silva --id.secret 111 -u https://admin:adminpw@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem --id.affiliation paciente
fabric-ca-client enroll -u https://silva:111@localhost:7054 --tls.certfiles $FABRIC_CA_HOME/tls-cert.pem --home /etc/hyperledger/fabric-ca-server/fabric-ca/clients/user6/

