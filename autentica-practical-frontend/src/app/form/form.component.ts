import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { formatDate } from '@angular/common';
import { TechnologyService } from '../service/technology/technology.service';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  @Output() eventEmitter = new EventEmitter<any>();
  applicationForm = this.fb.group({
    description: ["", Validators.maxLength(300)],
    email: ["", [Validators.required, Validators.email]],
    neededTill: [formatDate(new Date(), "yyyy-MM-dd HH:mm", "en"), Validators.required],
    technology: this.fb.group({
      type: ["", Validators.required],
      ram: [4, Validators.required],
      cores: [1, Validators.required],
      motherboard: ["", Validators.required],
      gpu: ["", Validators.required],
    }),
  });

  motherboards : Array<string> = [];
  gpus : Array<string> = [];

  constructor(private fb: FormBuilder, private technologyService: TechnologyService) {}

  ngOnInit(): void {
    this.motherboards = this.technologyService.technologyMotherboards(this.technologyTypes[0]);
    this.gpus = this.technologyService.technologyGPU(this.technologyTypes[0]);
    this.applicationForm.patchValue({
      technology: {
        type: this.technologyTypes[0],
        motherboard: this.motherboards[0],
        gpu: this.gpus[0],
      }
    });
  }

  get controls() {return this.applicationForm.controls;}
  get techControls() {return this.controls.technology.controls;}

  get technologyTypes() { return this.technologyService.technologyTypes;}
  get technologyRAM() { return this.technologyService.technologyRAM;}
  get technologyCores() { return this.technologyService.technologyCores;}

  onTypeChange(event: any) {
    this.motherboards = this.technologyService.technologyMotherboards(event.target.value)
    this.gpus = this.technologyService.technologyGPU(event.target.value)
    this.applicationForm.patchValue({
      technology: {
        type: event.target.value,
        motherboard: this.motherboards[0],
        gpu: this.gpus[0],
      }
    });
  }

  onSubmit() {
    if (this.applicationForm.valid) {
      const newApplication : any = this.applicationForm.value;
      newApplication.id = 0;
      newApplication.created = new Date().getTime();
      newApplication.status = "sent";
      newApplication.technology.id = 0;
      newApplication.neededTill = new Date(newApplication.neededTill).getTime();
      this.emitEvent(newApplication);
    }
  }

  emitEvent(app: any | null) {
    this.applicationForm.reset();
    this.eventEmitter.emit(app);
  }
}
