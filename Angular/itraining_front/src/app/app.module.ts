import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
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
import {TrainingFieldComponent} from './training-field/training-field.component';
import {ContactComponent} from './contact/contact.component';
import {ProgrammingLangagesComponent} from './training-field/programming-langages/programming-langages.component';
import {ReseauxComponent} from './training-field/reseaux/reseaux.component';
import {GestionProjetComponent} from './training-field/gestion-projet/gestion-projet.component';
import {SystemesExploitationComponent} from './training-field/systemes-exploitation/systemes-exploitation.component';
import {
  ProgrammingLangagesItemComponent
} from './training-field/programming-langages/programming-langages-item/programming-langages-item.component';
import {HttpClientModule} from '@angular/common/http';
import {ProfileComponent} from './account/profile/profile.component';
import {
  DomainesFormationComponent
} from './account/administrator-account/domaines-formation/domaines-formation.component';
import {AddFormationComponent} from './account/administrator-account/add-formation/add-formation.component';
import { FormationsLangagesProgrammationComponent } from './account/administrator-account/domaines-formation/formations-langages-programmation/formations-langages-programmation.component';
import { FormationsReseauxComponent } from './account/administrator-account/domaines-formation/formations-reseaux/formations-reseaux.component';
import { FormationsGestionProjetComponent } from './account/administrator-account/domaines-formation/formations-gestion-projet/formations-gestion-projet.component';
import { FormationsSystemesExploitationComponent } from './account/administrator-account/domaines-formation/formations-systemes-exploitation/formations-systemes-exploitation.component';
import { FormateursComponent } from './account/administrator-account/formateurs/formateurs.component';

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
    SystemesExploitationComponent,
    ProgrammingLangagesItemComponent,
    ProfileComponent,
    DomainesFormationComponent,
    AddFormationComponent,
    FormationsLangagesProgrammationComponent,
    FormationsReseauxComponent,
    FormationsGestionProjetComponent,
    FormationsSystemesExploitationComponent,
    FormateursComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
