[![Minecraft](https://img.shields.io/badge/Minecraft-1.8%20--%201.21%2B-brightgreen)](https://www.spigotmc.org/)
[![Spigot](https://img.shields.io/badge/Spigot-Supported-orange)](https://www.spigotmc.org/)
[![Paper](https://img.shields.io/badge/Paper-Supported-blue)](https://papermc.io/)

Un plugin Minecraft **ultra-leggero** che permette ai giocatori di vedere il proprio ping tramite il comando `/ping` (e altri alias)

---

## ✨ Caratteristiche

-  **Comando `/ping`** con alias: `/latenza`, `/latency`, `/ms`, `/pingping`.
-  **Messaggi personalizzabili** con placeholder `%ping%` e `%player%`.
-  **Supporto colori** con codici `&` (es. `&a`, `&e`, `&l`).
-  **Comando `/reload`** per lo staff (ricarica `config.yml` senza riavviare).
-  **`/reload` invisibile** ai giocatori normali (nessun messaggio di errore).
-  **Compatibile da 1.8 a 1.21+** su Spigot e Paper.

---

## 📦 Installazione

1. Scarica il file `FancyPing.jar` da [Releases](../../releases).
2. Copialo nella cartella `plugins/` del tuo server Minecraft.
3. Riavvia il server.
4. La cartella `plugins/FancyPing/` verrà creata con `config.yml`.

---

## 🎮 Comandi

| Comando | Alias | Permesso | Descrizione |
|---------|-------|----------|-------------|
| `/ping` | `/latenza`, `/latency`, `/ms`, `/pingping` | `fancyping.use.ping` | Mostra il tuo ping |
| `/reload` | — | `fancyping.admin.reload` | Ricarica la configurazione |

---

## 🔑 Permessi

| Permesso | Default | Descrizione |
|----------|---------|-------------|
| `fancyping.use.ping` | Tutti | Permette l'uso di `/ping` e alias |
| `fancyping.admin.reload` | OP | Permette l'uso di `/reload` |

---
