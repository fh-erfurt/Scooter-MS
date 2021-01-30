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

<br />
<br />

## About
### About the project
In our Scooter Management System, Areas (Type Area) can be created, where the Scooters (Type Scooter) are allowed to move.
In the test, there is an Area Erfurt which spans between the following coordinates:
- N50.95 <---> N51.0
- E11.00 <---> E11.06

You can view the interactive scribblemap [here](https://www.scribblemaps.com/create/#/id=ScooterMapEF&lat=50.98352366&lng=11.01784203&z=13&t=custom_style)
<br />

In the Scooter-MS, a Customer is able to rent a Scooter.
An Admin can do what the Customer can do, but is employed and is responsible for one Area. When a Scooter is reported as damaged by a Customer, the Admin must check what is wrong with the Scooter.
A ScooterHunter is able to do what the Customer can do, but the ScooterHunter also can top up his balance by recharging Scooter with low battery level. This balance then can be withdrawn.

<br />
<p align="center">
<img src="https://raw.githubusercontent.com/fh-erfurt/Scooter-MS/main/assets/Scooter-MS-Map-Animation.gif" alt="ScooterMap" width="400"/>
</p>

<br />

## Software
### The Software used to create this Project

- <img src="https://logonoid.com/images/intellij-idea-logo.png" alt="IntelliJ" width="16"/>
  IntelliJ Idea for Coding
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
### Credits to the people whose work has advanced our project

- [CloudBees](https://github.com/cloudbees) for their [PlantUML GitHub action](https://github.com/cloudbees/plantuml-github-action)
- [Vincent A. Cicirello](https://github.com/cicirello) for his [javadoc-cleanup Github Action](https://github.com/cicirello/javadoc-cleanup)
- [Stefan Zweifel](https://github.com/stefanzweifel) for his [git-auto-commit Github Action](https://github.com/stefanzweifel/git-auto-commit-action)
- [Jason Winn](https://github.com/jasonwinn) for his [Haversine formula Java implementation](https://github.com/jasonwinn/haversine)