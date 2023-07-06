import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HeaderComponent} from "./components/header/header.component";
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ComponentsModule} from "./components/components.module";
import {PagenotfoundComponent} from "./components/pagenotfound/pagenotfound.component";
import {HttpClientModule} from '@angular/common/http';
import {ApiModule, Configuration, ConfigurationParameters} from './remote';
import {environment} from '../environments/environment';
import {AlertsComponent} from './components/alerts/alerts.component';

export function apiConfigFactory(): Configuration {
  const params: ConfigurationParameters = {
    basePath: environment.api,
  }
  return new Configuration(params);
}

@NgModule({
  declarations: [
    HeaderComponent,
    AppComponent,
    PagenotfoundComponent,
    AlertsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ComponentsModule,
    HttpClientModule,
    ApiModule.forRoot(apiConfigFactory)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
