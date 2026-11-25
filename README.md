🔐 Cryptography Practical Lab (CryptographySh)
A comprehensive collection of hands-on Cryptography and Network Security experiments implemented as part of the B.Tech 5th Semester Cryptography Course (CSL0509) at ITM University, Gwalior (Department of SoCIS, Section D – AI/ML).
This repository documents 16 practical experiments spanning classical ciphers, cryptanalysis, symmetric and asymmetric encryption, cryptographic hashing, digital signatures, X.509 certificates, network traffic inspection, password auditing, SSH key-based authentication, VPN tunneling, and wireless security.

📊 Repository Badges
    

📑 Table of Contents
Project Overview
Objectives of the Project
Cryptography Concepts Covered
Complete Practical Index
Detailed Explanation of Each Practical
Technologies and Tools Used
Project Folder Structure
Installation and Setup Instructions
How to Run the Programs
Sample Input and Output
Learning Outcomes
Applications of Cryptography
Future Improvements
Author Information
Connect With Me
License

📖 Project Overview
Modern digital communication relies on cryptographic primitives to guarantee confidentiality, integrity, authentication, and non-repudiation. This repository serves as a structured practical archive covering both theoretical foundations and real-world security implementations across three core domains:
Classical & Modern Encryption: Visual simulation of substitution/transposition ciphers and block ciphers using CrypTool 2.1, alongside programmatic implementations in Java.
Public Key Infrastructure (PKI) & Hashing: Command-line cryptographic operations using OpenSSL for RSA key generation, SHA-256 digests, digital signatures, and X.509 self-signed certificates.
Network & System Security: Packet-level TLS/HTTPS and VPN inspection with Wireshark, password strength auditing with John the Ripper, passwordless OpenSSH authentication, OpenVPN configuration on Kali Linux, and WPA2-PSK (AES) wireless simulation in Cisco Packet Tracer.

🎯 Objectives of the Project
Understand the working mechanisms and security trade-offs of classical substitution and transposition ciphers.
Perform frequency analysis and brute-force cryptanalysis to identify vulnerabilities in weak ciphers.
Implement and compare symmetric block ciphers (DES and AES) and asymmetric algorithms (RSA and Diffie–Hellman).
Build Java applications utilizing BigInteger and the Java Cryptography Architecture (javax.crypto, java.security) for encryption, key exchange, hashing, and salted password storage.
Generate and verify cryptographic hashes, digital signatures, and X.509 certificates via OpenSSL.
Inspect encrypted vs. unencrypted network traffic and configure secure remote access (SSH, OpenVPN) and wireless encryption (WPA2-AES).

🧠 Cryptography Concepts Covered
Domain
Algorithms & Protocols
Classical Ciphers
Caesar Cipher, Vigenère Cipher, Rail Fence (Transposition) Cipher
Cryptanalysis
Unigram Frequency Analysis, Brute-Force Key Search, Dictionary & Incremental Attacks
Symmetric Encryption
DES (Data Encryption Standard – 56-bit effective key), AES (Advanced Encryption Standard – 128-bit)
Asymmetric Cryptography
RSA (Rivest–Shamir–Adleman), Diffie–Hellman Key Exchange
Hashing & Integrity
SHA-256 Message Digest, Salted Password Hashing (SecureRandom + SHA-256), SHA-512 crypt ($6$)
PKI & Authentication
Digital Signatures (sha256WithRSAEncryption), X.509v3 Self-Signed Certificates, OpenSSH RSA Key Pairs
Network & Wireless Security
HTTPS / TLS 1.2 Handshake & Cipher Suites, OpenVPN (tun0, Easy-RSA), WPA2-PSK (AES)


📋 Complete Practical Index
Exp. No.
Title
Core Concept
Tools / Language
1
Classical Ciphers Implementation
Caesar, Vigenère & Rail Fence Ciphers
CrypTool 2.1
2
Frequency Analysis & Cryptanalysis
Letter Frequency & Brute-Force Attack
CrypTool 2.1
3
Symmetric Encryption Comparison
DES vs. AES Block Ciphers
CrypTool 2.1
4
RSA File Encryption & Decryption
Asymmetric Key Pair & File Encryption
OpenSSL 1.0.0, Windows CMD
5
SHA-256 Hashing & Digital Signatures
Message Integrity & RSA Signing
OpenSSL 1.0.0, Windows CMD
6
Self-Signed X.509 Digital Certificate
Public Key Infrastructure (PKI)
OpenSSL 1.0.0, Windows CMD
7
RSA & Diffie–Hellman Implementation
Public-Key Crypto & Secret Key Exchange
Java (RSA.java, DiffieHellman.java)
8
AES Encryption & SHA-256 Application
Confidentiality & Integrity (AES-128 + SHA-256)
Java (AESHash.java)
9
Password Hashing With & Without Salting
Cryptographic Salting & Rainbow Table Defense
Java (PasswordHashing.java)
10
HTTPS & TLS Handshake Traffic Analysis
TLS 1.2 Handshake, Cipher Suites & Certificates
Wireshark, Web Browser
11
Encrypted VPN vs. Unencrypted HTTP Traffic
Tunnel Encryption vs. Plaintext HTTP
Wireshark, VPN Client
12
Secure vs. Insecure Protocol Analysis
Packet Inspection (HTTP, DNS, TLS)
Wireshark
13
Password Auditing with John the Ripper
Dictionary (rockyou.txt) & Brute-Force Attacks
Kali Linux, John the Ripper, OpenSSL
14
Passwordless SSH Authentication
4096-bit RSA Key-Based Remote Login
Kali Linux, OpenSSH
15
Secure VPN Configuration with OpenVPN
PKI-Authenticated VPN Tunnel (UDP 1194, tun0)
Kali Linux, OpenVPN 2.7.8, Easy-RSA
16
Secure Wireless Network (WPA2-AES)
WPA2-PSK Authentication & AES Wireless Encryption
Cisco Packet Tracer


🔬 Detailed Explanation of Each Practical
Experiment 1: Classical Ciphers Implementation
Objective: Implement Caesar, Vigenère, and Rail Fence ciphers to encrypt and decrypt plaintext (HELLO WORLD), and compare their working and effectiveness.
Cryptography Concept: Monoalphabetic substitution, polyalphabetic substitution, and transposition ciphers.
Algorithm Explanation:
Caesar Cipher (Shift = 3): Shifts each plaintext letter forward by 3 positions in the alphabet (HELLO WORLD  KHOOR ZRUOG).
Vigenère Cipher (Key = KEY): Repeats the keyword across letters (KEYKE YKEYK) and shifts each letter according to the corresponding key character (HELLO WORLD  RIJVS UYVJN).
Rail Fence Cipher (3 Rails): Arranges characters in a zigzag pattern across 3 rails and reads row-by-row (HOR ELWLDLO / HOLELWRDLO without spaces).
Tools Used: CrypTool 2.1 (Text Input, Caesar, Vigenère, Transposition, Text Output components).
Execution Steps: Build a workspace connecting Text Input to the respective cipher component, configure the key/action (Encrypt or Decrypt), and route output to Text Output.
Experiment 2: Frequency Analysis & Cryptanalysis
Objective: Perform frequency analysis on classical ciphertexts and analyze their vulnerability to cryptanalysis attacks.
Cryptography Concept: Statistical unigram frequency distribution and brute-force key exhaustion.
Algorithm Explanation: English text exhibits predictable letter frequencies (e.g., E, T, A, O). Because the Caesar cipher preserves one-to-one letter mappings and has only 25 non-zero shifts, comparing ciphertext frequencies against standard English distributions or testing all 25 keys breaks the cipher immediately.
Tools Used: CrypTool 2.1 (Caesar, Frequency Test).
Execution Steps: Encrypt the sample pangram paragraph with Caesar shift 3, pass the ciphertext into the Frequency Test component, and inspect unigram frequency bars (H, L, V, R peaking in ciphertext corresponding to E, I, S, O).
Experiment 3: Symmetric Encryption Comparison (DES vs. AES)
Objective: Encrypt sample data (HELLO BTECH STUDENTS) using DES and AES algorithms, and compare their security features and performance.
Cryptography Concept: Symmetric block ciphers (ECB mode with zero padding).
Algorithm Explanation:
DES: Operates on 64-bit blocks with a 56-bit effective key (key used: HelloWar). Vulnerable to modern brute-force attacks.
AES: Operates on 128-bit blocks with 128/192/256-bit keys (128-bit key used: Chaurasiya). Provides strong resistance against cryptanalysis and high performance on modern hardware.
Tools Used: CrypTool 2.1 (String Decoder, DES, AES, String Encoder).
Execution Steps: Decode UTF-8 plaintext and key inputs into byte streams, encrypt using DES and AES components, encode output as Hexadecimal, and reverse the pipeline to verify recovery of HELLO BTECH STUDENTS.
Experiment 4: RSA File Encryption & Decryption
Objective: Generate 2048-bit RSA public and private key pairs and perform secure file encryption and decryption using OpenSSL.
Cryptography Concept: Asymmetric (public-key) cryptography.
Tools Used: OpenSSL 1.0.0, Windows Command Prompt (CMD).
Execution Steps:
```cmd
openssl genrsa -out private.pem 2048
openssl pkey -in private.pem -pubout -out public.pem
openssl rsautl -encrypt -pubin -inkey public.pem -in message.txt -out encrypted.bin
openssl rsautl -decrypt -inkey private.pem -in encrypted.bin -out decrypted.txt
fc /b message.txt decrypted.txt
```
Expected Output: encrypted.bin (256 bytes) is generated and decrypted into decrypted.txt, with fc /b confirming FC: no differences encountered.
Experiment 5: SHA-256 Hashing & Digital Signatures
Objective: Generate SHA-256 hash values, create digital signatures, and verify their authenticity using OpenSSL.
Cryptography Concept: Cryptographic hash functions and asymmetric digital signatures.
Tools Used: OpenSSL 1.0.0, Windows Command Prompt (CMD).
Execution Steps:
```cmd
openssl dgst -sha256 message.txt
openssl dgst -sha256 -sign private.pem -out signature.bin message.txt
openssl dgst -sha256 -verify public.pem -signature signature.bin message.txt
```
Expected Output: Outputs the 64-character hexadecimal SHA-256 digest and prints Verified OK upon signature verification.
Experiment 6: Self-Signed X.509 Digital Certificate
Objective: Create a self-signed X.509v3 digital certificate and analyze its attributes, validity period, and security features.
Cryptography Concept: Digital Certificates and Public Key Infrastructure (PKI).
Tools Used: OpenSSL 1.0.0, Windows Command Prompt (CMD).
Execution Steps:
```cmd
openssl genrsa -out cert_private.pem 2048
openssl req -new -x509 -key cert_private.pem -out certificate.pem -days 365 -sha256 -subj "/C=IN/ST=Madhya Pradesh/L=Gwalior/O=ITM University/OU=IT/CN=localhost"
openssl x509 -in certificate.pem -text -noout
openssl verify -CAfile certificate.pem certificate.pem
```
Expected Output: Displays X.509v3 fields (sha256WithRSAEncryption, 2048-bit modulus, 365-day validity, Subject/Authority Key Identifiers) and outputs certificate.pem: OK.
Experiment 7: RSA & Diffie–Hellman Implementation in Java
Objective: Implement RSA and Diffie–Hellman algorithms from scratch using modular arithmetic in Java.
Cryptography Concept: Modular exponentiation, Euler's totient function (n)=(p-1)(q-1), modular multiplicative inverse, and discrete logarithm key exchange.
Language & Files: Java (RSA.java, DiffieHellman.java).
Algorithm Explanation:
RSA (RSA.java): Uses primes p=61,q=53 (n=3233,(n)=3120), public exponent e=17, and private exponent d=2753 to compute $C = M^e \bmod n$ and $M = C^d \bmod n$.
Diffie–Hellman (DiffieHellman.java): Uses public prime p=23 and generator g=5. Alice and Bob compute $A = g^a \bmod p$ and $B = g^b \bmod p$, deriving identical shared secret $S = B^a \bmod p = A^b \bmod p$.
Experiment 8: AES Encryption & SHA-256 Application
Objective: Develop a Java console application to secure text messages using AES-128 encryption and SHA-256 integrity hashing.
Cryptography Concept: Symmetric key generation (KeyGenerator), Base64 ciphertext encoding, and SHA-256 digest generation (MessageDigest).
Language & File: Java (AESHash.java).
Execution Steps: Generates a 128-bit AES SecretKey, encrypts user input using Cipher.getInstance("AES"), computes its SHA-256 hash, and decrypts the Base64 payload to verify message recovery.
Experiment 9: Password Hashing With & Without Salting
Objective: Implement password hashing with and without cryptographic salting and evaluate resistance against rainbow-table attacks.
Cryptography Concept: Cryptographically secure pseudo-random number generation (SecureRandom) and salted SHA-256 hashing.
Language & File: Java (PasswordHashing.java).
Execution Steps: Computes an unsalted SHA-256 digest alongside a salted digest prepended with a 16-byte random salt, demonstrating why identical passwords yield distinct hashes when salted.
Experiment 10: HTTPS & TLS Handshake Traffic Analysis
Objective: Capture HTTPS network traffic using Wireshark and analyze the TLS handshake, digital certificates, and cipher suites.
Cryptography Concept: Transport Layer Security (TLSv1.2), Client Hello / Server Hello, Cipher Suite negotiation (e.g., TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256), and X.509 server certificates.
Tools Used: Wireshark, Google Chrome / Microsoft Edge.
Execution Steps: Capture packets on the active Wi-Fi interface while visiting https://www.google.com, filter with tls and tls.handshake, inspect Client Hello cipher suites, and verify the browser certificate chain (WE2 / Google Trust Services).
Experiment 11: Encrypted VPN vs. Unencrypted HTTP Traffic
Objective: Capture and analyze encrypted VPN traffic using Wireshark and compare it with unencrypted HTTP communication.
Cryptography Concept: End-to-end tunnel encryption vs. cleartext network transmission.
Tools Used: Wireshark, VPN client, Web Browser.
Execution Steps: Capture HTTP packets visiting http://neverssl.com (filtered via http) where headers and payloads are readable in ASCII, then enable VPN and capture encrypted tunnel packets (Encrypted_VPN_Traffic.pcapng) where payloads appear obfuscated.
Experiment 12: Secure vs. Insecure Protocol Analysis
Objective: Analyze captured network packets to distinguish secure and insecure communication protocols.
Cryptography Concept: Protocol-level confidentiality (HTTP and DNS plaintext exposure vs. TLSv1.2 encrypted records).
Tools Used: Wireshark.
Execution Steps: Apply display filters http, dns, and tls on captured Wi-Fi traffic (wireshark_Wi-FiEVWAY3.pcapng) to compare plaintext HTTP GET requests/responses and DNS queries against encrypted TLS application data.
Experiment 13: Password Auditing with John the Ripper
Objective: Perform password auditing using John the Ripper and evaluate password strength against dictionary and brute-force attacks.
Cryptography Concept: Salted SHA-512 crypt hashes ($6$), dictionary attacks (rockyou.txt), and incremental character-space brute-forcing.
Tools Used: Kali Linux, John the Ripper, OpenSSL, RockYou Wordlist.
Execution Steps:
openssl passwd -6 -salt salt1 "password123" > hashes.txt
openssl passwd -6 -salt salt2 "admin@123" >> hashes.txt
john --format=sha512crypt --wordlist=/usr/share/wordlists/rockyou.txt hashes.txt
john --format=sha512crypt --show hashes.txt
john --format=sha512crypt --incremental=Digits --min-length=4 --max-length=4 brute.txt
Expected Output: Common dictionary passwords (password123) and short numeric PINs (1234) are cracked rapidly, while complex passwords (admin@123) resist quick dictionary lookup.
Experiment 14: Passwordless SSH Authentication
Objective: Generate 4096-bit SSH/RSA key pairs and configure passwordless authentication between Linux systems.
Cryptography Concept: Asymmetric challenge-response authentication (id_rsa private key & id_rsa.pub authorized public key).
Tools Used: Kali Linux, OpenSSH Client & Server.
Execution Steps:
sudo apt update && sudo apt install openssh-client openssh-server -y
sudo systemctl enable --now ssh
ssh-keygen -t rsa -b 4096
ssh-copy-id localhost
ssh localhost
Expected Output: Logs into localhost directly without prompting for a user password.
Experiment 15: Secure VPN Configuration with OpenVPN
Objective: Configure a secure VPN server using OpenVPN and Easy-RSA on Kali Linux and verify encrypted tunnel initialization.
Cryptography Concept: Mutual PKI certificate authentication (ca.crt, server.crt, client.crt), TLS authentication key (ta.key), and Certificate Revocation Lists (crl.pem).
Tools Used: Kali Linux, OpenVPN 2.7.8, Easy-RSA.
Execution Steps:
./easyrsa sign-req server server
./easyrsa sign-req client client
./easyrsa gen-crl
openvpn --genkey secret ta.key
sudo systemctl start openvpn-server@server
ip addr show tun0
sudo ss -lunp | grep 1194
Expected Output: OpenVPN initializes (Initialization Sequence Completed), brings up virtual tunnel interface tun0 (10.8.0.1/24), and listens on UDP 1194.
Experiment 16: Secure Wireless Network (WPA2-AES)
Objective: Design and implement a secure wireless network using WPA2-PSK encryption (AES) in Cisco Packet Tracer and verify connectivity.
Cryptography Concept: IEEE 802.11i / WPA2-PSK authentication with AES-CCMP encryption.
Tools Used: Cisco Packet Tracer (WRT300N Wireless Router, Laptop0, PC0).
Execution Steps: Configure Wireless Router0 (192.168.0.1, DHCP range 192.168.0.100–149) with WPA2 Personal and AES encryption, connect Laptop0 via wireless interface (192.168.0.100), and run ping 192.168.0.1 from the laptop command prompt.
Expected Output: Packets: Sent = 4, Received = 4, Lost = 0 (0% loss).

🛠️ Technologies and Tools Used
Programming Language: Java (JDK)
Cryptographic Simulation: CrypTool 2.1 (Stable Build 9778.2)
CLI Cryptography & PKI: OpenSSL (1.0.0 on Windows / 3.6.3 on Kali Linux), Easy-RSA
Network Protocol & Wireless Analyzers: Wireshark, Cisco Packet Tracer
Security Auditing & Remote Access: John the Ripper, OpenSSH (10.4p1), OpenVPN (2.7.8)
Operating Systems & IDE: Windows 10/11, Kali Linux, Visual Studio Code

📁 Project Folder Structure
CryptographySh/
├── README.md                                      # Comprehensive repository documentation
├── Cryptography practical file (AutoRecovered).docx # Complete lab record & output screenshots
└── Java_Programs/                                 # Java cryptographic implementations (Exp 7–9)
    ├── RSA.java                                   # Exp 7A: RSA key generation, encryption & decryption
    ├── DiffieHellman.java                         # Exp 7B: Diffie-Hellman shared secret exchange
    ├── AESHash.java                               # Exp 8: AES-128 encryption & SHA-256 hashing
    └── PasswordHashing.java                       # Exp 9: Salted vs. unsalted SHA-256 password hashing
(Note: Experiments 1–6 and 10–16 are documented with step-by-step configurations, commands, and verified terminal/GUI screenshots in the lab record.)

⚙️ Installation and Setup Instructions
Prerequisites
Java Development Kit (JDK 8 or higher) for compiling and executing Java programs (Experiments 7–9).
OpenSSL installed and added to system PATH (Experiments 4–6).
CrypTool 2.1 on Windows (Experiments 1–3).
Wireshark and Cisco Packet Tracer (Experiments 10–12, 16).
Kali Linux with john, openssh-server, openvpn, and easy-rsa packages (Experiments 13–15).
Clone the Repository
git clone https://github.com/shivchaurasiya/CryptographySh.git
cd CryptographySh

▶️ How to Run the Programs
1. Running the Java Programs (Experiments 7, 8, and 9)
Navigate to the directory containing the .java source files and compile/run each program using javac and java:
# Experiment 7A: RSA Encryption & Decryption
javac RSA.java
java RSA

# Experiment 7B: Diffie-Hellman Key Exchange
javac DiffieHellman.java
java DiffieHellman

# Experiment 8: AES Encryption & SHA-256 Hashing
javac AESHash.java
java AESHash

# Experiment 9: Password Hashing With & Without Salting
javac PasswordHashing.java
java PasswordHashing
2. Running OpenSSL CLI Practicals (Experiments 4, 5, and 6)
Create a working folder with a sample message.txt file and run:
# Generate 2048-bit RSA Key Pair
openssl genrsa -out private.pem 2048
openssl pkey -in private.pem -pubout -out public.pem

# Encrypt & Decrypt File
openssl rsautl -encrypt -pubin -inkey public.pem -in message.txt -out encrypted.bin
openssl rsautl -decrypt -inkey private.pem -in encrypted.bin -out decrypted.txt

# Generate SHA-256 Digest & Sign/Verify File
openssl dgst -sha256 message.txt
openssl dgst -sha256 -sign private.pem -out signature.bin message.txt
openssl dgst -sha256 -verify public.pem -signature signature.bin message.txt

# Generate & Verify Self-Signed X.509 Certificate
openssl req -new -x509 -key private.pem -out certificate.pem -days 365 -sha256
openssl verify -CAfile certificate.pem certificate.pem

💻 Sample Input and Output
Experiment 7A — RSA.java
Input:
Enter a numerical message (less than 3233): 65
Output:
===== RSA Key Generation =====
p = 61
q = 53
n = 3233
phi(n) = 3120

Public Key  = (17, 3233)
Private Key = (2753, 3233)

===== RSA Encryption =====
Original Message  : 65
Encrypted Message : 2790
Decrypted Message : 65

RSA Successful: true
Experiment 7B — DiffieHellman.java
Input:
Enter Alice's private key: 6
Enter Bob's private key: 15
Output:
===== Diffie-Hellman Key Exchange =====
Public Prime (p)     : 23
Public Generator (g) : 5

===== Public Key Exchange =====
Alice's Public Key : 8
Bob's Public Key   : 19

===== Shared Secret =====
Alice's Shared Secret : 2
Bob's Shared Secret   : 2

Key Exchange Successful!
Both parties have established the same shared secret.
Experiment 8 — AESHash.java
Input:
Enter a text message: Hello BTech Students
Output:
Encrypted Message: h06W/T8/qi9LWrOZMKmDTsuiDm0hABTXmh4zEHhSENo=
SHA-256 Hash: c664fcbe025645be0a0a053ba1895b1e979eb38ff33e63c0997ee23f60fac7f3
Decrypted Message: Hello BTech Students
Message Recovered: true
Experiment 9 — PasswordHashing.java
Input:
Enter password: hello123
Output:
===== Without Salting =====
Password Hash: 27cc6994fc1c01ce6659c6bddca9b69c4c6a9418065e612c69d110b3f7b11f8a

===== With Salting =====
Salt: 863b0d945e759ecc6455ec00ee9ecfda
Salted Hash: 681d6615857f4cdac7aa6fc10eb4b5f2ac228e76ee56540817f00919428fdfe9

===== Security Comparison =====
Same password gives same unsalted hash.
Random salt makes the salted hash different.
Salting improves resistance to rainbow-table attacks.

🎓 Learning Outcomes
Cryptographic Algorithm Design: Gained practical fluency in implementing modular arithmetic algorithms (RSA, Diffie–Hellman) and standard JCA APIs (AES, SHA-256, SecureRandom) in Java.
Cryptanalysis Awareness: Demonstrated mathematically and empirically why classical ciphers fail against frequency analysis and why unsalted hashes fall to rainbow-table and dictionary attacks.
PKI & Certificate Lifecycle Management: Mastered generating RSA key pairs, signing digests, and issuing/verifying X.509v3 certificates using OpenSSL and Easy-RSA.
Network Protocol & Infrastructure Hardening: Learned to inspect live TLS handshakes in Wireshark, configure key-based OpenSSH authentication, deploy an OpenVPN server on Linux, and secure wireless LANs with WPA2-AES.

🌐 Applications of Cryptography
Secure Web Communication (HTTPS/TLS): Protecting sensitive web traffic, online banking, and API communications via TLS handshakes, ECDHE key exchange, and X.509 certificates.
Authentication & Access Control: Securing remote server administration with SSH key pairs and protecting user credentials using salted adaptive hashing.
Virtual Private Networks (VPNs): Creating encrypted IP tunnels across untrusted public networks using OpenVPN and TLS authentication keys.
Wireless Network Security: Preventing eavesdropping and unauthorized access on Wi-Fi networks using WPA2/WPA3 with AES encryption.
Digital Signatures & Document Integrity: Ensuring software packages, legal documents, and financial transactions have not been tampered with in transit.

🚀 Future Improvements
Add standalone Java implementations for AES-GCM authenticated encryption and RSA-OAEP padding (replacing basic ECB/textbook RSA demonstrations for production-grade security).
Implement modern memory-hard password hashing algorithms (PBKDF2, bcrypt, or Argon2) alongside SHA-256 in Experiment 9.
Include the CrypTool .cwm workspace files, Wireshark .pcapng packet captures, and Cisco Packet Tracer .pkt topology files directly in organized subdirectories.
Add automated unit tests (JUnit) for all Java cryptographic classes.

👨‍💻 Author Information
Name: Shivam Chaurasiya
Academic Details: B.Tech 5th Semester (Section D – AI/ML), Dept. of SoCIS, ITM University, Gwalior
Course: Cryptography (CSL0509)
GitHub Profile: @shivchaurasiya
Repository: CryptographySh

🤝 Connect With Me
GitHub: https://github.com/shivchaurasiya
Project Repository: https://github.com/shivchaurasiya/CryptographySh

📄 License
No license is currently specified for this repository. All code and documentation are shared for educational and academic purposes.
