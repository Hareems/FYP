using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;


namespace QuraanMemorizer.Models
{
    public class QuraanTextAyat
    {
        public int Id { get; set; }
        public int SurrahId { get; set; }
        public int AayatNo { get; set; }
        public int JuzzId { get; set; }
        public string ImageName { get; set; }
        
        public  ICollection<QuraanAudio> QuranAudio { get; set; }
        public  Juzz Juzz { get; set; }
        public  Surrah Surrah { get; set; }
        
    }
}