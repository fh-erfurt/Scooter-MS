## Scooter Management System

![Java Badge](https://img.shields.io/badge/Java-15-red)
[![CI](https://img.shields.io/github/workflow/status/fh-erfurt/Scooter-MS/build/main?style=flat&logo=apache-maven)](https://github.com/fh-erfurt/Scooter-MS/actions?query=workflow%3Abuild)
[![Docs](https://img.shields.io/badge/javadoc-see%20here-9cf.svg?style=flat&logo=java)](https://fh-erfurt.github.io/Scooter-MS)


<p align="center">
<img src="https://raw.githubusercontent.com/fh-erfurt/Scooter-MS/main/assets/Logo.png" alt="PlantUML" width="350"/>
</p>

  <br/>

## Table of Contents

- [About](#about)
- [Software](#software)
- [Diagrams](#diagrams)
- [Credits](#credits)


## About
### About the project
In unserem Scooter Management System können Umgebungen (Area) erstellt werden, in denen sich die Scooter (welche beim Instanziieren einer Umgebung zugewiesen werden) bewegen dürfen.
In unserem Test gibt es die Umgebung Erfurt, welche sich zwischen folgenden Koordinaten aufspannt:
- N50.95 <---> N51.0
- E11.00 <---> E11.06

Anschauen kann man die Karte [hier](https://www.scribblemaps.com/create/#/id=ScooterMapEF&lat=50.98352366&lng=11.01784203&z=13&t=custom_style)

<br />

<p align="center">
<img src="https://raw.githubusercontent.com/fh-erfurt/Scooter-MS/main/assets/Scooter-MS-Map-Animation.gif" alt="ScooterMap" width="300"/>
</p>

<br />
<br />

## Software
### The Software used to create this Project

- <img src="https://logonoid.com/images/intellij-idea-logo.png" alt="IntelliJ" width="16"/>
  IntelliJ Idea for Development
  <br />
- <img src="https://cdn4.iconfinder.com/data/icons/small-n-flat/24/map-512.png" alt="Plantuml" width="17"/>
  Scribblemaps.com for the embedded Area Image
  <br />
- 📊 PlantUML IntelliJ integration
  <br />
  <br />

## Diagrams
### Class Diagramm
<img src="https://raw.githubusercontent.com/fh-erfurt/Scooter-MS/main/assets/umldiagram.png" alt="PlantUML" width="800"/>

<br />
<br />

## Credits

- to [CloudBees](https://github.com/cloudbees) for their [PlantUML GitHub action](https://github.com/cloudbees/plantuml-github-action)
- to [Vincent Cicirello](https://github.com/cicirello) for his [javadoc-cleanup Github Action](https://github.com/cicirello/javadoc-cleanup)
- to [Stefan Zweifel](https://github.com/stefanzweifel) for his [git-auto-commit Github Action](https://github.com/stefanzweifel/git-auto-commit-action)
- to [Jason Winn](https://github.com/jasonwinn) for his [Haversine formula Java implementation](https://github.com/jasonwinn/haversine)