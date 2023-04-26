 export class Technology {
  id: number;
  type: string;
  ram: number;
  cores: number;
  motherboard: string;
  gpu: string;

  constructor(id: number, type: string, ram: number, cores: number, motherboard: string, gpu: string) {
    this.id = id;
    this.type = type;
    this.ram = ram;
    this.cores = cores;
    this.motherboard = motherboard;
    this.gpu = gpu;
  }

  toDTO() : any {
    return {
      id: this.id,
      type: this.type,
      ram: this.ram,
      cores: this.cores,
      motherboard: this.motherboard,
      gpu: this.gpu,
    };
  }

  static toModel(data: any) : Technology {
    return new Technology(data.id, data.type, data.ram, data.cores, data.motherboard, data.gpu);
  }
}