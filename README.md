# 🛡️ AegisPandora

AegisPandora is an ultra-secure, offline-first **password manager** inspired by the layered protection of legendary artifacts and modern military protocols. Built with love in Kotlin Multiplatform, it ensures that your secrets remain **yours**—untouched, encrypted, and evacuated if under threat.

---

## 🔐 Philosophy

Inspired by:
- 🖼️ *Mona Lisa's transparent protection* – a delicate layer above the masterpiece
- 🏛️ *Vault-grade museum security* – triggering lockdown when threats emerge
- 🛩️ *Military exfiltration logic* – data is encrypted & ejected when under fire

When your vault is compromised, it doesn’t panic—it *evaporates securely*.

---

## 🚀 Features

- 🔓 **PIN + Biometric Login**  
  Layered access with 8-digit PIN & fingerprint.

- 🔐 **Encrypted Vault**  
  Stored locally using high-grade algorithms (Argon2/Bcrypt optional).

- 🕵️ **Intrusion Monitoring**  
  Locks app for 5 minutes after 3 failed attempts.

- 💥 **Ejection Mechanism**  
  On breach: encrypted data is:
  - Sent to user email *(simulated)*
  - Stored in a **secure folder**
  - Then wiped from memory and disk

- 💡 **Personal Recovery Questions**  
  Secure fallback if PIN is forgotten.

- 📤 **Offline-Only by Design**  
  No server. No cloud. No tracking.

---

## 🛠️ Tech Stack

- **Kotlin Multiplatform (KMP)**
- Jetpack Compose / SwiftUI (planned)
- Multiplatform Serialization
- Secure Local Storage
- Mock Email & Device Reboot Simulators

---

## 📂 Project Structure

