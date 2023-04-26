import { Technology } from "./technology.model";

export class Application {
  id: number;
  description: string;
  status: string;
  email: string;
  created: number;
  neededTill: number;
  technology: Technology | null;

  constructor(id: number, description: string, status: string, email: string, created: number, neededTill: number, technology: Technology | null) {
    this.id = id;
    this.description = description;
    this.status = status;
    this.email = email;
    this.created = created;
    this.neededTill = neededTill;
    this.technology = technology;
  }

  toDTO() : any {
    return {
      id: this.id,
      description: this.description,
      status: this.status,
      email: this.email,
      created: this.created,
      neededTill: this.neededTill,
      technology: this.technology
    };
  }

  static toModel(data: any, technology: Technology | null) : Application {
    return new Application(data.id, data.description, data.status, data.email, data.created, data.neededTill, technology);
  }
}