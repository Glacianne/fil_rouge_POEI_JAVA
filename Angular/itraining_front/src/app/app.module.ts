import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HomeComponent} from "./home/home.component";
import {NavbarComponent} from "./navbar/navbar.component";
import {FooterComponent} from "./footer/footer.component";
import {AccountComponent} from "./account/account.component";
import {TeacherAccountComponent} from "./account/teacher-account/teacher-account.component";
import {LearnerAccountComponent} from "./account/learner-account/learner-account.component";
import {AdministratorAccountComponent} from "./account/administrator-account/administrator-account.component";
import {InscriptionComponent} from "./inscription/inscription.component";
import {ConnectedComponent} from "./account/connected.component/connected.component";
import {
  InscriptionFormateurComponent
} from "./inscription/inscription-formateur.component/inscription-formateur.component";
import {ConnectionComponent} from "./connection/connection.component";
import { TrainingFieldComponent } from './training-field/training-field.component';
import { ContactComponent } from './contact/contact.component';
import { ProgrammingLangagesComponent } from './training-field/programming-langages/programming-langages.component';
import { ReseauxComponent } from './training-field/reseaux/reseaux.component';
import { GestionProjetComponent } from './training-field/gestion-projet/gestion-projet.component';
import { SystemesExploitationComponent } from './training-field/systemes-exploitation/systemes-exploitation.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    AccountComponent,
    TeacherAccountComponent,
    LearnerAccountComponent,
    AdministratorAccountComponent,
    InscriptionComponent,
    ConnectedComponent,
    InscriptionFormateurComponent,
    ConnectionComponent,
    TrainingFieldComponent,
    ContactComponent,
    ProgrammingLangagesComponent,
    ReseauxComponent,
    GestionProjetComponent,
    SystemesExploitationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
