using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using Microsoft.AspNet.Identity.EntityFramework;
using QuraanMemorizer.Models;


namespace QuraanMemorizer.DAL
{
    public class ApplicationDbContext : IdentityDbContext<ApplicationUser>
    {


        public ApplicationDbContext() : base("DefaultConnection")
        {

        }


        public DbSet<Surrah> Surrah { get; set; }
        public DbSet<Juzz> Juzz { get; set; }
        public DbSet<QuraanAudio> QuraanAudio { get; set; }
        public DbSet<QuraanTextAyat> QuraanText { get; set; }
        public DbSet<Sabaq> Sabaq { get; set; }
        public DbSet<Message> Message { get; set; }
        public DbSet<Reciter> Reciter { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            modelBuilder.Entity<Message>().HasRequired(i => i.Sender).WithMany().WillCascadeOnDelete(false);
            modelBuilder.Entity<Sabaq>().HasRequired(i => i.Student).WithMany().WillCascadeOnDelete(false);
            base.OnModelCreating(modelBuilder);
        }

        public static ApplicationDbContext Create()
        {
            return new ApplicationDbContext();
        }

    }
}